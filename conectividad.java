import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.List;

/**
 * Write a description of class Main here.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class conectividad
{
    public static void main(String[] args) {
        Arguments config = new Arguments(args);
        if (config.isHelpEnabled()) {
            config.showHelp();
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(config.getInputFile()))) {
            String line = reader.readLine();
            String[] parts = line.split("\\s+");

            int n = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            Graph graph = new Graph(n);
            
            line = reader.readLine();
            
            while(line != null){
                parts = line.split("\\s+");
                if(parts.length != 3) {
                    throw new IllegalArgumentException (
                        "Missing argument for node in text input."
                    );
                }
                graph.addEdge(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]));
                line = reader.readLine();
            }
            
            Prim primSolver = new Prim();
            MinimumSpanningTree mst = primSolver.calculateMSTree(graph, config.isTraceEnabled(), y);
                    
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(config.getOutputFile()))) {
                
                bw.write(Integer.toString(mst.getCost()));
                bw.newLine();
    
                for (Edge e : mst.getEdges()) {
                    bw.write((e.getOriginNode() + 1) + " " + (e.getTargetNode() + 1) + " " + e.getWeight());
                    bw.newLine();
                }
    
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}