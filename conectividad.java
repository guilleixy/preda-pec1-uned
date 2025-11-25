import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: Move FileRead to separate file?
        
        //createTree(trace);
    }
}