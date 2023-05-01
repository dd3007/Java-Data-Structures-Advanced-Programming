// Only the uppercase letters in the string

import java.util.Scanner;

public class E63a{
    
    public static void main(String[] args){
        
// Get string from user + initialize variables
        
        Scanner input;
        System.out.println("Hello there! Enter a phrase, please ");
        input = new Scanner(System.in);
        
        String phrase = input.nextLine();
        int length = phrase.length();
        String upperCase = "";
        
// Use charAt() method (fro)Chapter 4.5.5
// Use isUpperCase() method -> tells apart uppercase letters
        
        for (int n = 0; n < length; n++)
        {
            if (Character.isUpperCase(phrase.charAt(n)))
            {
                upperCase = upperCase + phrase.charAt(n);
            }
        }

//Print upperCase
        
        System.out.println("The uppercase letters are: " + upperCase);
           
    }
}
