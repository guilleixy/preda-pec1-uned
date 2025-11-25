import java.util.List;

/**
 * Result of a Minimum Spanning Tree calculation.
 * Contains list of edges and total cost.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class MinimumSpanningTree
{
    private final List<Edge> edges;
    private final int cost;

    public MinimumSpanningTree(List<Edge> edges, int cost) {
        this.edges = edges;
        this.cost = cost;
    }
    
    /** @return the list of edges that form the MST */
    public List<Edge> getEdges(){
        return edges;
    }
    
    /** @return the total cost of the MST */
    public int getCost(){
        return cost;
    }
}