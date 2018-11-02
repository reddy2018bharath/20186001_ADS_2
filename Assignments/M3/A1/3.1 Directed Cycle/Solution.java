import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused constructor.
    }
    /**
     * { Client Program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        Digraph di = new Digraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = sc.nextLine().split(" ");
            di.addEdge(Integer.parseInt(tokens[0]),
            Integer.parseInt(tokens[0]));
        }
        DirectedCycle dc = new DirectedCycle(di);
        if (dc.hasCycle()) {
            System.out.println("Cycle exists");
        } else {
            System.out.println("Cycle doesn't exists");
        }
    }
}



