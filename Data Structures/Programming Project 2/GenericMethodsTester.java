//*************************************************************************
// Subject: GenericMethodsTester Class for GenericMethods
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************
import java.util.*;

public class GenericMethodsTester{
 
    public static void main(String[] args){
        
        GenericMethods gm = new GenericMethods();
        Rectangle b = new Rectangle (8.0, 3.5);
        Rectangle a[] = new Rectangle [5];
        a[0] = new Rectangle(2.5, 5.2);
        a[1] = new Rectangle(3.2, 4.5);
        a[2] = new Rectangle(1.0, 2.0);
        a[3] = new Rectangle(5.5, 7.0);
        a[4] = new Rectangle(8.0, 3.5);
        
        // Linear Search Test
        int c = gm.linearSearch(a, b);
        System.out.println("LS Analysis -> Position: " + c);
      
        // Binary Search Test
        Arrays.sort(a); // Array has to be sorted in order to apply BS
        
        int d = gm.binarySearch (a, b);
        System.out.println("BS Analysis -> Position: " + d);
    }
}
