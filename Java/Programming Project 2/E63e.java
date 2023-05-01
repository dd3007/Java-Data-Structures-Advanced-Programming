// The position of all vowels in the string

import java.util.Scanner;

public class E63e{
    
    public static void main(String[] args){
        
// Get string from user + initialize variables        
        
        Scanner input;
        System.out.println("Hello there! Enter a phrase, please ");
        input = new Scanner(System.in);
        
        String phrase = input.nextLine();
        int length = phrase.length();
        String output = "";

// Vowel location process!
// Use indexOf() method -> if = -1, letter is not vowel 
        
        String vowels = "AEIOUaeiou";
        
        for (int n = 0; n < length; n++)
        {
            char character = phrase.charAt(n);
 
 // Remark: For my exercise, the position n is the index position!
            
            if (vowels.indexOf(character) != -1)
            {
                output = output + " " + n;
            }
        }
        
// Print locations
            
        System.out.println("The vowel locations are" + output);
                
        
            
    }
}
