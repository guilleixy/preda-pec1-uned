
/**
 * Write a description of class Edge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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