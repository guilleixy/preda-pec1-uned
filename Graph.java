import java.util.List;
import java.util.ArrayList;

/**
 * Represents undirected weighted graph using adjacency lists.
 * Each node maintains a list of edges connecting it to neighboring nodes.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class Graph
{
    private int n;
    private List<List<Edge>> adjacent;
    
    public Graph(int n) {
        this.n = n;
        adjacent = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjacent.add(new ArrayList<>());      
        }   
    }
    
    /**
     * Adds an undirected edge between two nodes with a given weight.
     * For undirected graphs, the edge is added to both nodes' adjacency lists.
     * 
     * @param originNode Index of the origin node
     * @param targetNode Index of the target node
     * @param weight Weight or cost of the edge
     */
    public void addEdge(int originNode, int targetNode, int weight) {
        adjacent.get(originNode).add(new Edge(originNode, targetNode, weight));
        adjacent.get(targetNode).add(new Edge(targetNode, originNode, weight));
    }
    
    public int getSize(){
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
        for (Edge e : adjacent.get(u)) {
            if (e.getTargetNode() == v) return true;
        }
        return false;
    }
    
    /**
     * Returns adjacent nodes to node .
     * 
     * @param u Index of the desired node
     * @return List of the edges from a node
     */
    public List<Edge> getAdjacency(int u){
        return adjacent.get(u);
    }
    
}