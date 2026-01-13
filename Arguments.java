
import java.io.File;

/**
 * Parses and validates command-line arguments
 * 
 * Expected usage:
 *   conectividad [-t] [-h] [inputFile] [outputFile]
 *   
 * If outputFile is omitted, a default file is used.
 * 
 * @author Guillermo Bernal Lou
 * @version 25/11/2025
 */
public class Arguments
{
    private boolean trace = false;
    private boolean help = false;
    private String inputFile = null;
    private String outputFile = null;
    
    public Arguments(String[] args) {
        parseArguments(args);
        validateArguments();
    }
    
    /**
     * Parses the arguments and assigns values to the corresponding fields.
     * -t enables trace mode
     * -h enables help mode
     * The first non-flag argument is the input file, the second is the output file.
     * @param args Array of command-line arguments
     */
    private void parseArguments(String[] args) {
        for(int i = 0; i < args.length; i++){
            switch (args[i]) {
                case "-t" -> trace = true;
                case "-h" -> {
                    help = true;
                    return;
                }
                default -> {
                    if (args[i].startsWith("-")) {
                        throw new IllegalArgumentException("Unknown option: " + args[i]);
                    }
                    if (inputFile == null) {
                        inputFile = args[i];
                    } else {
                        outputFile = args[i];
                    }
                }
            }
        }
        
    }
    
    /**
     * Validates the arguments after parsing.
     * Throws an exception if the input file is missing or does not exist.
     */
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
    
    /**
     * Displays help information on how to use the program.
     */
    public void showHelp(){
        System.out.println("SINTAXIS: conectividad [-t][-h] [fichero entrada] [fichero salida]");
        System.out.println(" -t                Traza cada paso");
        System.out.println(" -h                Muestra esta ayuda");
        System.out.println(" [fichero entrada] Valores n, y, conexiones y su coste");
        System.out.println(" [fichero salida]  Conexiones seleccionadas y coste total");        
    }
    
    /** @return true if trace mode is enabled */
    public boolean isTraceEnabled() {
        return trace;
    }

    /** @return true if help was requested */
    public boolean isHelpEnabled() {
        return help;
    }
    
    /** @return Input file name */
    public String getInputFile() {
        return inputFile;
    }
    
    /** @return Output file name */
    public String getOutputFile() {
        return outputFile;
    }
    
}