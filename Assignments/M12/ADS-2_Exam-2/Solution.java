import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
        int vertices = Integer.parseInt(sc.nextLine());
        int edges = Integer.parseInt(sc.nextLine());
        EdgeWeightedGraph edgeWeightedGraph =
        new EdgeWeightedGraph(vertices);
        EdgeWeightedDigraph edgeWeightedDigraph =
        new EdgeWeightedDigraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = sc.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            DirectedEdge dedge = new DirectedEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            edgeWeightedGraph.addEdge(edge);
            edgeWeightedDigraph.addEdge(dedge);
            
        } 
        String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
		System.out.println(edgeWeightedGraph);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] tokens = sc.nextLine().split(" ");
			//int p = sc.nextInt();
			//int q = sc.nextInt();
			DijkstraSP dj= new DijkstraSP(edgeWeightedDigraph, Integer.parseInt(tokens[0]));
			//if (dj.hasPathTo(int tokens[1])) {
			System.out.println(dj.distTo(Integer.parseInt(tokens[1])));
		//} else {
			//System.out.println("No Path Found.");
		//}
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			//sc.nextLine();
			//String[] tokens1 = sc.nextLine().split(" ");
			

			break;

		default:
			break;
		}

	}
}