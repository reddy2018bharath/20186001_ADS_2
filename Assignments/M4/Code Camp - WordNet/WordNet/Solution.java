/**
 * class for Solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String synsetsFileName = StdIn.readLine();
        String hypernymsFileName = StdIn.readLine();
        String str2 = StdIn.readLine();
        switch (str2) {
        case "Graph":
            try {
                WordNet wn = new WordNet(synsetsFileName, hypernymsFileName);
                wn.display();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        case "Queries":
            try {
                WordNet wnq = new WordNet(synsetsFileName,
                                          hypernymsFileName);
                while (StdIn.hasNextLine()) {
                    String line = StdIn.readLine();
                    String[] strarr = line.split(" ");
                    if (strarr[0].equals("0")) {
                        throw new IllegalArgumentException(
                            "IllegalArgumentException");
                    }
                    System.out.println("distance = " + wnq.distance(strarr[0],
                                       strarr[1]) + ", ancestor = " + wnq.sap(strarr[0],
                                               strarr[1]));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        default:
            break;
        }
    }
}
