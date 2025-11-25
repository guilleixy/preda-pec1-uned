import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Prim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prim
{
    public MinimumSpanningTree calculateMSTree(Graph g, boolean trace, int y){
        int n = g.getSize();
        boolean visited[] = new boolean[n];
        List<Edge> mst = new ArrayList<>();
        int totalCost = 0;
        visited[0] = true;
        while(mst.size() < n - 1){
            Edge bestEdge = null;
            for(int u = 0; u < n; u++){
                if(!visited[u]) continue;
                for(int v = 0; v < n; v++){
                    if(visited[v]) continue;
                    if(!g.isConnected(u, v)) continue;
                    int weight = (u * v) % y;
                    if (bestEdge == null || weight < bestEdge.getWeight()) {
                        bestEdge = new Edge(u, v, weight);
                    }
                }
            }
            if (bestEdge == null) {
                throw new RuntimeException("Graph is not connected");
            }
            mst.add(bestEdge);
            totalCost += bestEdge.getWeight();

            visited[bestEdge.getTargetNode()] = true;

            if (trace) {
                System.out.println("Añadida arista: " + bestEdge);
            }
        }
        return new MinimumSpanningTree(mst, totalCost);
    }
}