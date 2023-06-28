package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 * @author Powell Longjohn
 */
public class Task1 {
    
    final static String FILE_NAME = "compounds.txt";
      
    public static List<Compound> readInTheData() throws IOException {
        List <Compound> compoundList = new ArrayList<>();
        LineReader file;
        file = new LineReader(FILE_NAME);
        while (! file.readEverything() ) {
            String compoundLine = file.getLineAndReadNext();
            compoundList.add(new Compound(compoundLine));
        }
        file.close();
        return compoundList;
    }

    public static List<String> uniqueNamesInOrderOf(List<Compound> theCompounds) 
            throws IOException {        
        List<String> compoundNames = new ArrayList<>();
        // Iterate to get names of compound
        for (Compound c: theCompounds){
            String name = c.getName();
            // Check if name already exists before adding
            if (! compoundNames.contains(name)){
                compoundNames.add(c.getName());
            }
        }
        // Sort names
        Collections.sort(compoundNames);
        return compoundNames;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException for in IO error
     */
    public static void main(String[] args) throws IOException {
        
        List <String> uniqueNamesInOrder = 
                uniqueNamesInOrderOf(readInTheData());
        
        if  (  uniqueNamesInOrder == null  )
            System.out.println("Task 1 not attempted");
        else {
            System.out.println("There are "+uniqueNamesInOrder.size()+
                    " unique compound names");
            System.out.println(
                    "In alphabetical order the name of the first compound is "+
                           uniqueNamesInOrder.get(0));
            System.out.println(
                    "In alphabetical order the name of the last compound is "+
                           uniqueNamesInOrder.get(uniqueNamesInOrder.size()-1));
        }
    }
    
}
