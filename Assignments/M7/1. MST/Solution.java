/**
 * { item_description }.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
/**
 * Constructs the object.
 */
    private Solution() {

    }
/**
 * { function_description }.
 *
 * @param      args  The arguments
 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(v);
        for (int i = 0; i < e; i++) {
            String[] tokens = sc.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(
                tokens[0]), Integer.parseInt(
                tokens[1]), Double.parseDouble(tokens[2]));
            weightedGraph.addEdge(edge);
        }
        KruskalMST kmst = new KruskalMST(weightedGraph);
        System.out.printf("%.5f\n", kmst.weight());

        

    }
}

