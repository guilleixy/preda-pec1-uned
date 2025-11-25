import java.util.List;

/**
 * Write a description of class MinimumSpanningTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinimumSpanningTree
{
    public final List<Edge> edges;
    public final int cost;

    public MinimumSpanningTree(List<Edge> edges, int cost) {
        this.edges = edges;
        this.cost = cost;
    }
}