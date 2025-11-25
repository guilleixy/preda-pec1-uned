import java.util.List;

/**
 * Write a description of class MinimumSpanningTree here.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class MinimumSpanningTree
{
    private List<Edge> edges;
    private int cost;

    public MinimumSpanningTree(List<Edge> edges, int cost) {
        this.edges = edges;
        this.cost = cost;
    }
    
    public List<Edge> getEdges(){
        return edges;
    }
    
    public int getCost(){
        return cost;
    }
}