import java.util.Scanner;
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		GraphForm graph = new GraphForm(size * size);
		while(sc.hasNext()) {
			String[] links = sc.nextLine().split(" ");
			graph.addEdge(Integer.parseInt(links[0]),
            Integer.parseInt(links[1]));
            //System.out.println(graph.hasEdge((Integer.parseInt(links[0]) - 1), Integer.parseInt(links[1]) - 1));
		}
		ConnectedComponents obj = new ConnectedComponents(graph, (size));
		System.out.println(obj.percolates());
	}
}