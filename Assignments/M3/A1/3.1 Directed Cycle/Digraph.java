/**
 * Class for digraph.
 */
public class Digraph {
    /**
     * { newline variable }.
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**
     * { vertices variable }.
     */
    private final int vertices;           // number of vertices in this digraph
    /**
     * { edges variable }.
     */
    private int edges;                 // number of edges in this digraph
    /**
     * { bag variable }.
     */
    private Bag<Integer>[] adj;    // adj[v] = adjacency list for vertex v
    /**
     * { indegree variable }.
     */
    private int[] indegree;        // indegree[v] = indegree of vertex v
    /**
     * Initializes an empty digraph with <em>V</em> vertices.
     *
     * @param  vertexOne the number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Digraph(final int vertexOne) {
        if (vertexOne < 0) {
         throw new IllegalArgumentException(
            "Number of vertices in a Digraph must be nonnegative");
     }
        this.vertices = vertexOne;
        this.edges = 0;
        indegree = new int[vertexOne];
        adj = (Bag<Integer>[]) new Bag[vertexOne];
        for (int v = 0; v < vertexOne; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int vertex() {
        return vertices;
    }

    /**
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int edge() {
        return edges;
    }
    /**
     * validate vertex function.
     *
     * @param      v     { parameter_description }
     */
    private void validateVertex(final int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("vertex "
             + v + " is not between 0 and " + (vertices - 1));
        }
    }

    /**
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException
     *  unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edges++;
    }

    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v}
     *  in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(final int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the number of directed edges incident
     *  from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(final int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the indegree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(final int v) {
        validateVertex(v);
        return indegree[v];
    }

    /**
     * Returns the reverse of the digraph.
     *
     * @return the reverse of the digraph
     */
    public Digraph reverse() {
        Digraph reverse = new Digraph(vertices);
        for (int v = 0; v < vertices; v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    /**
     * Returns a string representation of the graph.
     *
     * @return the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + NEWLINE);
        for (int v = 0; v < vertices; v++) {
            s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}



