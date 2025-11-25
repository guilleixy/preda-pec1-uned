
import java.io.File;

/**
 * Write a description of class Arguments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arguments
{
    private boolean trace = false;
    private boolean help = false;
    private String inputFile = null;
    private String outputFile = "fallbackOutputFile.txt";
    
    public Arguments(String[] args) {
        parseArguments(args);
        validateArguments();
    }
    
    private void parseArguments(String[] args) {
        for(int i = 0; i < args.length; i++){
            if (args[i].equals("-t")) {
                trace = true; 
            } else if (args[i].equals("-h")) {
                help = true;
                return;
            } else if(inputFile == null) {
                inputFile = args[i];
            } else {
                outputFile = args[i];
            }
        }
        
    }
    
    private void validateArguments(){
        if (help) return;
        
        if (inputFile == null) {
            throw new IllegalArgumentException (
                "ERROR: No input file."
            );
        }
        
        File testFile = new File(inputFile);
        if (!testFile.exists()) {
            throw new IllegalArgumentException (
                "ERROR: Input file does not exist: " + inputFile + "."
            );
        }
    }
    
    public void showHelp(){
        System.out.println("SINTAXIS: conectividad [-t][-h] [fichero entrada] [fichero salida]");
        System.out.println(" -t                Traza cada paso");
        System.out.println(" -h                Muestra esta ayuda");
        System.out.println(" [fichero entrada] Valores n, y, conexiones y su coste");
        System.out.println(" [fichero salida]  Conexiones seleccionadas y coste total");        
    }
    
    public boolean isTraceEnabled() {
        return trace;
    }

    public boolean isHelpEnabled() {
        return help;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }
    
}