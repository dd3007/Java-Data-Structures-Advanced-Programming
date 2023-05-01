//*************************************************************************
// Subject: RectangleTester Class for the Rectangle Object
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************

public class RectangleTester {
    
    public static void main (String[] args){
        
        Rectangle a = new Rectangle(5.0,2.5);
        Rectangle b = new Rectangle(4.2,3.4);
        
        // rectangle a - get length
        double length = a.getLength();
        System.out.println(length);
        
        // rectangle b - get width
        double width = b.getWidth();
        System.out.println(width);
        
        // calculate parameter
        double perimeter = a.perimeter();
        System.out.println(perimeter);
        
        // compareTo method
        int comparison = b.compareTo(a);
        System.out.println(comparison);
    }
    
} // end of class

