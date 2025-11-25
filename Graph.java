import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Graph here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Graph
{
    private int n;
    //private int y;
    private List<List<Edge>> adjacent;
    
    public Graph(int n) {
        this.n = n;
        //this.y = y;
        adjacent = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjacent.add(new ArrayList<>());      
        }   
    }
    
    public void addEdge(int originNode, int targetNode, int weight) {
        adjacent.get(originNode).add(new Edge(originNode, targetNode, weight));
        adjacent.get(targetNode).add(new Edge(targetNode, originNode, weight));
    }
    
    public int getSize(){
        return n;
    }
    
    public boolean isConnected(int u, int v) {
        for (Edge e : adjacent.get(u)) {
            if (e.getTargetNode() == v) return true;
        }
        return false;
    }
    
}