//*************************************************************************
// Subject: Rectangle Class, Implementing RectangleInterface and Comparable
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************

public class Rectangle implements RectangleInterface, Comparable<Rectangle> {

    public double perimeter;
    public double lengthRect;
    public double widthRect;

    // Constructor
   
    public Rectangle(double length, double width){
        
        lengthRect = length;
        widthRect = width;
    }
   
    
    // Methods to get length and width of rectangle
    // (RectangleInterface implemented)
    
    public double getLength(){
        return lengthRect;
    }

    public double getWidth(){
        return widthRect;
    }
    
    
    // Methods to calculate and get perimeter of rectangle
  
    public double perimeter(){
        perimeter = (2 * getLength()) + (2 * getWidth());
        return perimeter; 
    }    
    
    // NOTE:i didn't write a void perimeter + a double getPerimeter method
    // because this way it's simpler to access perimeters when implementing
    // the Comparable Interface

    
    // Method to compare perimeters (Comparable Interface implemented)
    
    public int compareTo(Rectangle a){
        double thisPerimeter = this.perimeter();
        double aPerimeter = a.perimeter();
        
        if (thisPerimeter > aPerimeter){
            return 1;
        }
        if (aPerimeter < thisPerimeter){
            return -1;
        }
        else {
            return 0;
        }
    }
        
} // end

