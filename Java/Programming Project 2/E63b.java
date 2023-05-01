// Every second character of the string

import java.util.Scanner;

public class E63b{
    
    public static void main(String[] args){
       
// Get string from user + initialize variables        
        
        Scanner input;
        System.out.println("Hello there! Enter a phrase, please ");
        input = new Scanner(System.in);
        
        String phrase = input.nextLine();
        int length = phrase.length();
        String secondCharacter = "";
 
// Define conditions for second character (secondCharacter)       
        
        for (int n = 1; n < length; n += 2)
        {
            secondCharacter = secondCharacter + phrase.charAt(n);
        }
        
// Print every second character 
        
        System.out.println("The 'second characters' are: " + secondCharacter);
    }
}
