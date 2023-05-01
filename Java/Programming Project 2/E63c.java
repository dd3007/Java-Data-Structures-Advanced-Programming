// The string, with all vowels replaced by an underscore.

import java.util.Scanner;

public class E63c{
    
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
            if (vowels.indexOf(character) == -1)
            {
                output = output + character;
            }
 
// Replace vowels by underscores
            
            else 
                output += "_";
        }
        
        System.out.println(output);
            
    }
}
