package assignment;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Powell Longjohn
 */
public class Task3 {
    
    final static int MAX=200, MIN=0, STEP=25;
    
    private static ListOfCompounds[] validAtTemperature;
    
    private static void populateValidAtTemperatureFrom(Compound[] theCompounds){
        // Initialise validAtTemperature
        validAtTemperature = new ListOfCompounds[MAX/STEP];
        // Check the compounds within the temperature range and populate
        // validAtTemperature
        for (int i = 0; i < MAX/STEP; i++){
            ListOfCompounds l = new ListOfCompounds();
            for (Compound c : theCompounds){
                if (c.validAt(i * STEP) || c.validAt((i + 1) * STEP - 1)){
                    l.addAnother(c);
                }
            }
        validAtTemperature[i] = l;
        }
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        populateValidAtTemperatureFrom(Task2.compoundsInOrder());
        
        if  (  validAtTemperature == null  )
            System.out.println("Task 3 not completed");
        else {
            System.out.println("The frequencies of the temperature ranges are");
            for (int i = 0; i<MAX/STEP; i++)
                System.out.println( 
                        String.format("%3d", i*STEP) + " - " +  
                        String.format("%3d", (i+1)*STEP-1) + 
                        String.format("%10d", validAtTemperature[i].size()));
            
            System.out.println();

            Integer test = Integer.valueOf(
                    JOptionPane.showInputDialog(
                            "What temperature are you interested in?"));
            if  (  test >= MIN && test < MAX  )  {
                System.out.println(
                        "The compounds with valid Antonine constants at " + 
                                test + " degrees are");
                System.out.println(validAtTemperature[test/STEP]);
            }
            else 
                System.out.println("It must be between " + MIN + " and " + 
                        (MAX-1));
        }

    }
    
}
