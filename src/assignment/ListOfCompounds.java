package assignment;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Powell Longjohn
 */
public class ListOfCompounds {
    
    private List<Compound> theList;
    
    public void addAnother(Compound c)  {
        if (theList == null){
            theList = new ArrayList<>();
            theList.add(c);
        }else{
            theList.add(c);
        }
        
    }
    
    public int size() {  
        if (theList != null){
            return theList.size();
        }
        return 0;
    }
    
    @Override
    public String toString() {
        String lastCompound = theList.get(theList.size() - 1).getName();
        String compoundString = "";
        for (Compound c : theList){
            compoundString += c.getName();
            if (! c.getName().equals(lastCompound)){
                compoundString += ", ";
            }
        }
        return compoundString;
    }
    
}
