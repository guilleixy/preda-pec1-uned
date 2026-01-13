import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.List;

/**
 * Reads a graph from a text file, computes a Minimum Spanning Tree (MST) using Prim's algorithm,
 * and writes the total cost and selected edges to an output file.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class conectividad
{
    public static void main(String[] args) {
        
        // Parse and validate command-line arguments
        Arguments config = new Arguments(args);
        
        // Show help and exit if requested
        if (config.isHelpEnabled()) {
            config.showHelp();
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(config.getInputFile()))) {
            
            // Read the first line containing number of nodes (n) and additional parameter y
            String line = reader.readLine();
            String[] parts = line.split("\\s+");

            int n = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            Graph graph = new Graph(n);
            
            // Read all edges
            line = reader.readLine();
            while(line != null){
                parts = line.split("\\s+");
                if(parts.length != 3) {
                    throw new IllegalArgumentException (
                        "Missing argument for node in text input."
                    );
                }
                
                // Add edge to the graph (subtract 1 to convert 1-based to 0-based indexing)
                graph.addEdge(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]));
                line = reader.readLine();
            }
            
            // Compute the MST using Prim's algorithm
            Prim primSolver = new Prim();
            MinimumSpanningTree mst = primSolver.calculateMSTree(graph, config.isTraceEnabled(), y);
            
            if(config.getOutputFile() != null){
                // Write the MST cost and edges to the output file        
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(config.getOutputFile()))) {
                    
                    bw.write(Integer.toString(mst.getCost()));
                    bw.newLine();
                    
                    // Write each edge in the MST (convert back to 1-based indexing for output)
                    for (Edge e : mst.getEdges()) {
                        bw.write((e.getOriginNode() + 1) + " " + (e.getTargetNode() + 1) + " " + e.getWeight());
                        bw.newLine();
                    }
        
                } catch (IOException e) {
                    e.printStackTrace();
                }     
            } else {
                    for (Edge e : mst.getEdges()) {
                        System.out.println((e.getOriginNode() + 1) + " " + (e.getTargetNode() + 1) + " " + e.getWeight());

                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}