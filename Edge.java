
/**
 * Represents an edge in a graph, connecting two nodes with a weight.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class Edge
{
    private int originNode;
    private int targetNode;
    private int weight;
    
    public Edge (int originNode, int targetNode, int weight) {
        this.originNode = originNode;
        this.targetNode = targetNode;
        this.weight = weight;
    }
    
    public int getOriginNode() {
        return originNode;
    }

    public int getTargetNode() {
        return targetNode;
    }

    public int getWeight() {
        return weight;
    }
}