/**
 * Class for directed cycle.
 */
public class DirectedCycle {
    /**
     * { marked variable }.
     */
    private boolean[] marked;
    // marked[v] = has vertex v been marked?
    /**
     * { edgeTo variable }.
     */
    private int[] edgeTo;
    // edgeTo[v] = previous vertex on path to v
    /**
     * { onstack variable }.
     */
    private boolean[] onStack;
    // onStack[v] = is vertex on the stack?
    /**
     * { cycle variable }.
     */
    private Stack<Integer> cycle;
    // directed cycle (or null if no such cycle)

    /**
     * Determines whether the digraph {@code G} has a directed cycle and, if so,
     * finds such a cycle.
     * @param graph the digraph
     */
    public DirectedCycle(final Digraph graph) {
        marked  = new boolean[graph.vertex()];
        onStack = new boolean[graph.vertex()];
        edgeTo  = new int[graph.vertex()];
        for (int v = 0; v < graph.vertex(); v++) {
            if (!marked[v] && cycle == null) {
                dfs(graph, v);
            }
        }
    }

    /**
     * { dfs function }.
     *
     * @param      gra    { parameter_description }
     * @param      ver     { parameter_description }
     */
    private void dfs(final Digraph gra, final int ver) {
        onStack[ver] = true;
        marked[ver] = true;
        for (int w : gra.adj(ver)) {

            // short circuit if directed cycle found
            if (cycle != null) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = ver;
                dfs(gra, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                for (int x = ver; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(ver);
                assert check();
            }
        }
        onStack[ver] = false;
    }

    /**
     * Does the digraph have a directed cycle?
     * @return {@code true} if the digraph has
     *  a directed cycle, {@code false} otherwise
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    /**
     * Returns a directed cycle if the digraph has
     * a directed cycle, and {@code null} otherwise.
     * @return a directed cycle (as an iterable) if
     * the digraph has a directed cycle,
     *    and {@code null} otherwise
     */
    public Iterable<Integer> cycle() {
        return cycle;
    }
    /**
     * { check function }.
     *
     * @return     { description_of_the_return_value }
     */
    private boolean check() {

        if (hasCycle()) {
            // verify cycle
            int first = -1, last = -1;
            for (int v : cycle()) {
                if (first == -1) {
                    first = v;
                }
                last = v;
            }
            if (first != last) {
                System.err.printf(
                "cycle begins with %d and ends with %d\n", first, last);
                return false;
            }
        }


        return true;
    }
}


