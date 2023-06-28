package assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * A class that reads in a file a line at a time
 * 
 */
public class LineReader {
    //Instance variables
    private String currentLine;
    private BufferedReader reader;

    //Constructors
    public LineReader (String fileName) throws IOException    {
        Path file = Path.of(fileName);
        reader = Files.newBufferedReader(file);
        currentLine = reader.readLine();        
    }

    public LineReader (Path file) throws IOException    {
        reader = Files.newBufferedReader(file);
        currentLine = reader.readLine();        
    }

    //Instance methods
    public boolean readEverything () {
        return currentLine == null;
    }

    public String getCurrentLine()  {
        return currentLine;
    }

    public String getLineAndReadNext() throws IOException  {
        String l = currentLine;
        readNextLine();         
        return l;
    }

    public void readNextLine() throws IOException  {
        currentLine = reader.readLine();         
    }

    public void close() throws IOException   {        
        reader.close();         
   }

}
