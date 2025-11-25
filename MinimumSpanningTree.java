import java.util.List;

/**
 * Write a description of class MinimumSpanningTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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