package assignment;

import java.util.Arrays;

/**
 *
 * @author Powell 
 */
public class Compound {
    
    private String name;
    private Double lowestTemperature, highestTemperature;
    private Double constantA, constantB, constantC;
    
    public Compound (String tabSeparatedLine)  {
        String[] compoundDetails = tabSeparatedLine.split("\t");
        name = compoundDetails[0];
        lowestTemperature = Double.valueOf(compoundDetails[1]);
        highestTemperature = Double.valueOf(compoundDetails[2]);
        constantA = Double.valueOf(compoundDetails[3]);
        constantB = Double.valueOf(compoundDetails[4]);
        constantC = Double.valueOf(compoundDetails[5]);
    }
    
    public String getName() {
        return name;
    }
    
    public boolean validAt(int temp) {
        if  (  lowestTemperature == null || highestTemperature == null  )
            return false;
        return  temp >= lowestTemperature && temp <= highestTemperature;
    }
       
    @Override
    public String toString() {
        return name + " has constants applicable between " + 
                (int) Math.round(lowestTemperature) + " and " + 
                (int) Math.round(highestTemperature);
    }
}
