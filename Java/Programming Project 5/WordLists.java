//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Contains analytical methods that create ArrayLists,
//  does not print words in new text file 
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Dani Dassum
//  Your UNI: dd3007
//**************************************

import java.io.*;
import java.util.*;

public class WordLists{
    
private File inFile;
    
    public WordLists(String fileName){

        // constructor that takes name of dictionary file as only parameter
        
        String name = fileName;
        inFile = new File (name);
    }
    
    public ArrayList<String> lengthN(int n) 
        throws FileNotFoundException {
        
        // returns ArrayList of all length n words (Strings) in dictionary file
        // From Example A, lecture 22 - I used Scanner() to analyze the words 
        // from the command-line arg and add the ones of size n to my ArrayList.
        
        Scanner input = new Scanner (inFile);
        ArrayList <String> lengthNList = new ArrayList <String> ();
        String word;
        
        while (input.hasNext()) {
            word = input.next();
            if (word.length() == n){
                lengthNList.add (word);
            }
        }
        return lengthNList;
    }

    public ArrayList<String> endsWith(char lastLetter, int n) 
        throws FileNotFoundException {

        // returns ArrayList of words length n ending with letter lastLetter
        // For this method, I created a nested if-while loop that analyzes each
        // word's last char - if it's equal to the user's input 'lastLetter,''
        // the word will be added to the ArrayList endsWithList.
        
        Scanner input = new Scanner (inFile);
        ArrayList <String> endsWithList = new ArrayList <String> ();
        String word;
        
        while (input.hasNext()) {
            word = input.next();
            int index = word.length() - 1;
            if (word.charAt(index) == lastLetter) {
                if (word.length() == n){
                    endsWithList.add (word);
                }
            }
        }
        return endsWithList;
    }

    public ArrayList<String> containsLetter(char included, int index, int n) 
        throws FileNotFoundException {

        // returns ArrayList of words length n with letter @ position index
        // I created a nested loop to test whether the word's length was n,
        // and the chat at index was 'included'. 
        
        Scanner input = new Scanner (inFile);
        ArrayList <String> containsLetterList = new ArrayList <String> ();
        String word;
        
        while (input.hasNext()) {
            word = input.next();
            if (word.length() == n && index < word.length()) {
                if (word.charAt(index) == included) {
                    containsLetterList.add (word);
                } 
            }
        }
        return containsLetterList;
    }
    
    public ArrayList<String> multiLetter(int m, char included) 
        throws FileNotFoundException {

        // returns ArrayList of words w/ m occurrences of letter included
        // I used nested loops w/ if statements and a counter to check the # of
        // reps of the char in each word & add it to ArrayList if it meets req

        Scanner input = new Scanner (inFile);
        ArrayList <String> multiLetterList = new ArrayList <String> ();
        String word;
        int counter;
        
        while (input.hasNext()) {
            counter = 0;
            word = input.next();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == included) {
                    counter++;
                    if (counter == m) {
                        multiLetterList.add (word);
                    }
                } 
            }
        }
        return multiLetterList;
    }
    
} // end of class








