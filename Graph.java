/**
 * Represents an undirected weighted graph using an adjacency matrix.
 * This representation is especially suitable for dense graphs, where
 * the number of edges is close to the maximum possible.
 * 
 * The graph is represented by a square matrix where:
 * - matrix[i][j] stores the weight of the edge between node i and node j.
 * - If no edge exists, the value is set to infinite (max int value).
 * - The diagonal elements (i == j) are set to 0.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class Graph {

    private int n;
    private int[][] matrix;
    private static final int INFINITE = Integer.MAX_VALUE;

    public Graph(int n) {
        this.n = n;
        matrix = new int[n][n];

        // Initialize adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = INFINITE; // Set to max Integer value so any weight will be smaller
            }
        }
    }

    /**
     * Adds an undirected edge between two nodes with a given weight.
     * Since the graph is undirected, the matrix is updated symmetrically.
     * 
     * @param u Index of the first node
     * @param v Index of the second node
     * @param weight Weight or cost of the edge
     */
    public void addEdge(int u, int v, int weight) {
        matrix[u][v] = weight;
        matrix[v][u] = weight;
    }

    public int getSize() {
        return n;
    }

    /**
     * Checks whether there is a direct edge between two nodes.
     * 
     * @param u Index of the first node
     * @param v Index of the second node
     * @return True if an edge exists between u and v; false otherwise
     */
    public boolean isConnected(int u, int v) {
        return matrix[u][v] != INFINITE;
    }

    /**
     * Returns the weight of the edge between u and v.
     */
    public int getWeight(int u, int v) {
        return matrix[u][v];
    }
}
