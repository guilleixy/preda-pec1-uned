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

            Graph graph = new Graph(n, y);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO: Move FileRead to separate file?
        
        //createGraph();
        //dos partes, primera linea y luego el arbol
        
        //createTree(trace);
    }
}