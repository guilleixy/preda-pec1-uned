import java.util.List;
import java.util.ArrayList;
/**
 * Implements Prim's algorithm to compute the Minimum Spanning Tree (MST) of a graph.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class Prim
{

    /**
     * Calculates the Minimum Spanning Tree (MST) of a given graph.
     * 
     * @param g Graph object containing nodes and edges
     * @param trace If true, prints each edge added to the MST
     * @param y Parameter used in the dynamic weight calculation: weight = (u * v) % y
     * @return MinimumSpanningTree object containing the selected edges and total cost
     * @throws RuntimeException if the graph is not connected
     */
    public MinimumSpanningTree calculateMSTree(Graph g, boolean trace, int y){
        int n = g.getSize();
        boolean visited[] = new boolean[n];
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;
        
        visited[0] = true; // start from node 0
        
        while(mst.size() < n - 1){
            Edge bestEdge = null;
            
            for(int u = 0; u < n; u++){
                if(!visited[u]) continue;
                
                for (int v = 0; v < n; v++) {
                    if (visited[v]) continue;
                    if (!g.isConnected(u, v)) continue;

                    int weight = (u * v) % y;

                    if (bestEdge == null || weight < bestEdge.getWeight()) {
                        bestEdge = new Edge(u, v, weight);
                    }
                }
            }
            
            // If no edge found, the graph is disconnected
            if (bestEdge == null) {
                throw new RuntimeException("Graph is not connected");
            }
            
            // Add the selected edge to the MST
            mst.add(bestEdge);
            totalCost += bestEdge.getWeight();
            
            // Mark added Node as visited
            visited[bestEdge.getTargetNode()] = true;
            
            // Print trace information if enabled
            if (trace) {
                System.out.println("Added Edge: " + bestEdge.getOriginNode() + " -> "
                                   + bestEdge.getTargetNode() + " (" + bestEdge.getWeight() + ")");
            }
        }
        return new MinimumSpanningTree(mst, totalCost);
    }
}