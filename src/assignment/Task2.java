package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 
 * @author Powell Longjohn
 */
public class Task2 {
    
    private static Compound findInList(List<Compound> theList,  String target) {
        for (Compound c : theList){
            if (c.getName().equals(target)){
                return c;
            }
        }
        return null;
    }
    
    public static Compound[] compoundsInOrder() throws IOException {
        List<Compound> originalCompounds = 
                Task1.readInTheData();
        List<String> namesInOrder = 
                Task1.uniqueNamesInOrderOf(originalCompounds);
        
        //Get the sorted compounds using the sorted names list
        List <Compound> sortedCompoundList = new ArrayList<>();
        for (String n : namesInOrder){
            Compound aCompound = findInList(originalCompounds, n);
            sortedCompoundList.add(aCompound);
        }
        
        //Convert list to array
        Compound[] compoundArray = sortedCompoundList.toArray(Compound[]::new);
        
        return compoundArray;
    }


    /**
     * @param args the command line arguments
     * @throws java.io.IOException for in IO error
     */
    public static void main(String[] args) throws IOException {
        
        Compound[] inOrder = compoundsInOrder(); 
        
        if  (  inOrder == null  )  
            System.out.println("Task 2 not completed");
        else {
            System.out.println("There are "+inOrder.length+" unique compounds");
            Integer test = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "Which one (as a number between 1 and " + 
                            inOrder.length + ") are you interested in?"));

            if  (  test >= 1 && test <= inOrder.length  )
                System.out.println(inOrder[test-1]);
            else 
                System.out.println(
                            "It must be a number between 1 and " + 
                            inOrder.length);
        }
        
    }
    
}
