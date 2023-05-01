//*************************************
//
//  WordTest.java
//
//  Test class for WordLists.java
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Dani Dassum
//  Your UNI: dd3007
//**************************************

import java.util.*;
import java.io.*;

public class WordTest {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        // my main method tests tries to run the code and catches mistakes
        // within the main method I have a couple of helper methods to test
        // and print the methods from WordLists.java
        
        try {
            String nameOne = args[1];
            boolean again = true;
            while (again) {
                WordLists wl = new WordLists("dictionary.txt");
                whatToPrint (nameOne);
                again = nextPrint ();
            }
            System.out.println ("Have a good day then!");
        }

        catch (FileNotFoundException fnfe) {
            System.out.println("BEEEEEP! System error! System error!");
            System.out.println("The file(s) provided was/were not found");
            System.out.println("Try running the program again!");
            System.out.println(fnfe);
        }
        
        catch (IllegalArgumentException iae) {
            System.out.println("BEEEEEP! System error! System error!");
            System.out.println("There was a problem with your inputs");
            System.out.println("Try running the program again!");
            System.out.println(iae);
        }
        
        catch (IndexOutOfBoundsException iobe) {
            System.out.println("BEEEEEP! System error! System error!");
            System.out.println("Insert your two valid command-line arguments!");
            System.out.println("Try running the program again!");
            System.out.println(iobe);
        }
        
        catch (NoSuchElementException nsee) {
            System.out.println("BEEEEEP! System error! System error!");
            System.out.println("There is no such element");
            System.out.println("Try running the program again!");
            System.out.println(nsee);
        }
        
        catch (Exception e) {
            System.out.println("BEEEEEP! System error! System error!");
            System.out.println("Try running the program again!");
            System.out.println(e);
        }
    }

    
 // ********* mainMethod() Helper Methods *************
    
    
    public static int optionChoosing () {
        
        // method to decide which method to test, I also added a
        // while loop in case user enters invalid input
        
        Scanner input = new Scanner (System.in);
        
        System.out.println ("Welcome to the WordLists tester!");
        System.out.println ("Enter the option (1-4) you'd like to execute");
        System.out.println ("1 - words of a desired length");
        System.out.println ("2 - words that end with a specific letter");
        System.out.println ("3 - words with character at a given index");
        System.out.println ("4 - words with a # of repetitions of a character");
        
        int decision = input.nextInt();
        while (!(decision > 1 || decision < 4)){
            System.out.println ("Insert a value between 1 and 4!");
            decision = input.nextInt();
        }
        return decision;
    }
    
    
    public static void whatToPrint (String n) throws FileNotFoundException {
        
        // based on the decision of optionChoosing(), it lets the compiler
        // now what to print (see File Printing section)
        
        int decision = optionChoosing();
        
        if (decision == 1) {
            printLengthN (n);
        }
        
        if (decision == 2) {
            printEndsWith (n);
        }
        
        if (decision == 3) {
            printContainsLetter (n);
        }
        
        if (decision == 4) {
            printMultiLetter (n);
        }
    }
               
    public static boolean nextPrint () {
        
        // Asks the user if they want to test another method, in
        // order to override the file originally created
        
        Scanner input = new Scanner (System.in);
        
        System.out.println ("Do you wish to choose another option?");
        System.out.println ("Enter '1' for YES and '2' for NO!");
        int choice = input.nextInt();
        boolean again = true;
        
        while (!(choice == 1 || choice == 2)) {
            System.out.println ("Enter either '1' for YES or '2'! for NO!");
            choice = input.nextInt();
        }
        
        if (choice == 1) {
            again = true;
        }
        
        else if (choice == 2) {
            again = false;
        }
        return again;
    }         
           
    
 // *********** File Printing ********************************
        
        
    public static void printLengthN (String n)
        throws FileNotFoundException {
        
        // method to print, in the file given by args[1], the words
        // of size n
        
        ArrayList <String> lengthNWords = new ArrayList <String> ();
        lengthNWords = lengthNTester ();
        PrintWriter output = new PrintWriter(n);
        for (String element: lengthNWords) {
            output.println(element);
        }
        output.close();
    }
        
    public static void printEndsWith (String n)
        throws FileNotFoundException {
        
        // method to print, in the file given by args[1], the words
        // of certain size which end in a certain letter
        
        ArrayList <String> EndsWithWords = new ArrayList <String> ();
        EndsWithWords = endsWithTester ();
        PrintWriter output = new PrintWriter(n);
        for (String element: EndsWithWords) {
            output.println(element);
        }
        output.close();
    }
    
    public static void printContainsLetter(String n)
        throws FileNotFoundException{
        
        // method to print, in the file given by args[1], the words
        // which contain a letter, at a given index, in a word of
        // a given size
        
        ArrayList <String> containsLetterWords = new ArrayList <String> ();
        containsLetterWords = containsLetterTester ();
        PrintWriter output = new PrintWriter(n);
        for (String element: containsLetterWords) {
            output.println(element);
        }
        output.close();
    }    
     
    public static void printMultiLetter (String n)
        throws FileNotFoundException{
       
        // method to print, in the file given by args[1], the words
        // which contain a specific number of repetitions of a character
        
        ArrayList <String> multiLetterWords = new ArrayList <String> ();
        multiLetterWords = multiLetterTester ();
        PrintWriter output = new PrintWriter(n);
        for (String element: multiLetterWords) {
            output.println(element);
        }
        output.close();
    }
    
            
 // *********** Tester Helper Methods *******************           
        
    
    public static ArrayList <String> lengthNTester() 
        throws FileNotFoundException {
        
        // official lengthNTester to test lengthN() method,
        // with valid user input, I used helped methods which made sure of this
        
        WordLists wl = new WordLists("dictionary.txt");
        
        int length = lengthCondition ();
            
        return wl.lengthN (length);
    }
        
        
    public static ArrayList <String> endsWithTester() 
        throws FileNotFoundException {
        
        // official endsWithTester to test endsWith() method,
        // with valid user input, I used helped methods which made sure of this
        
        WordLists wl = new WordLists("dictionary.txt");
        
        char letter = endsWithCondition ();
        int length = lengthCondition ();
        
        return wl.endsWith (letter, length);
    }
        
        
    public static ArrayList <String> containsLetterTester() 
        throws FileNotFoundException {
        
        // official containsLetterTester to test containsLetter() method,
        // with valid user input, I used helped methods which made sure of this
        
        WordLists wl = new WordLists("dictionary.txt");
        
        char character = includedCharCondition ();
        int length = lengthCondition ();
        int index = indexCondition (length);
        
        return wl.containsLetter(character, index, length);
    }
        
        
    public static ArrayList <String> multiLetterTester()
        throws FileNotFoundException {
        
        // official multiLetterTester to test multiLetter() method,
        // with valid user input, I used helped methods which made sure of this
        
        WordLists wl = new WordLists("dictionary.txt");
        
        char character = includedCharCondition ();
        int m = occurrencesCondition () ;
        
        return wl.multiLetter(m, character);
    }
    
        
  // ************ More Helper Methods *****************  
        
    
    public static int lengthCondition () {
        
        Scanner input = new Scanner (System.in);
            
        // this method tests if user's input for length condition
        // is valid, or else he'll get miserably stuck in a while loop
        
        System.out.println ("Enter desired length of words");
        int length = input.nextInt();
        while (!(length > 0 || length == (int)length)) {
            System.out.println ("Enter a valid length!");
            length = input.nextInt();
        }
        return length;
    }
    
    public static char endsWithCondition () {
        
        // this method tests if the user's input for the endsWith method
        // is valid, otherwise he'll get stuck in a while loop
        
        Scanner input = new Scanner (System.in);
        
        System.out.println ("Enter letter you'd like your word to end with");
        char letter = input.next().charAt(0);
        while (!(Character.isAlphabetic(letter))) {
            System.out.println ("Enter just one alphabetic character!");
            letter = input.next().charAt(0);
        }
        return letter;
    }
            
    public static char includedCharCondition () {
        
        // this method tests if the user's input for a character
        // is valid, otherwise he'll get stuck in a while loop
        
        Scanner input = new Scanner (System.in);
        
        System.out.println ("Enter character you want the words to include");
        char character = input.next().charAt(0);
        while (!(Character.isAlphabetic(character))) {
            System.out.println ("Enter just one alphabetic character!");
            character = input.next().charAt(0);
        }
        return character;
    }
            
    public static int indexCondition (int length) {
        
        // this method tests if the user's input for the index
        // is valid, otherwise he'll get stuck in a while loop
        
        Scanner input = new Scanner (System.in);

        System.out.println ("Enter the index where you want said character");
        int index = input.nextInt();
        while (!(index > 0 || index == (int)index || index < length)) {
            System.out.println ("Enter a valid index!");
            index = input.nextInt();
        }
        return index;
    }
            
    public static int occurrencesCondition () {
        
        // this method tests if the user's input for the occurrences int m
        // is valid, otherwise he'll get stuck in a while loop
        
        Scanner input = new Scanner (System.in);
        
        System.out.println ("Enter number of desired occurrences of character");
        int m = input.nextInt();
        while (!(m > 0 || m == (int)m)) {
            System.out.println ("Enter a valid number of occurrences!");
            m = input.nextInt();
        }
        return m;
    }
} // end of class








