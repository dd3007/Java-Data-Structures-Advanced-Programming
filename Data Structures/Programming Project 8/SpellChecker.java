//*************************************************************************
// Subject: SpellChecker, implements SpellCheckerInterface
// Name: Dani Dassum, dd3007
// Date: 08/03/2021
// Sources:
// - Scanner & hasNextLine() approach from Homework 4
// - String methods: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
// - \p{Punct}: https://www.tutorialspoint.com/posix-character-classes-p-punct-java-regex
// - toString() method from class
//*************************************************************************
import java.util.*;
import java.io.*;

public class SpellChecker implements SpellCheckerInterface {
    
    private HashSet <String> dictionary; // HashSet instance required later
    
    // check for spelling errors in an input file, referencing a provided dictionary filename
    
    // Constructor of the class (takes in filename)
    public SpellChecker (String filename) {
        
        try {
            dictionary = new HashSet <String> (); // to store dictionary words
            
            File file = new File (filename);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.toLowerCase();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') &&
                        !(c >= '0' && c <= '9')) {
                        line.replace(String.valueOf(c), "");
                    }
                }
                dictionary.add(line); // assuming each line is a word
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Insert a valid file name");
        }
    }
    
    public List<String> getIncorrectWords(String filename) {
        
        ArrayList <String> incorrectWordList = new ArrayList <>();
        
        try {
            File file = new File (filename);
            Scanner scanner = new Scanner (file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String [] wordList = line.split(" ");
                
                for (String word : wordList) {
                    word = word.toLowerCase();
                    word = word.replaceAll("\\p{Punct}", "");
                    
                    if (!word.equals("") && !dictionary.contains(word)) {
                        incorrectWordList.add(word);
                    }
                }
            }
            
        }
        catch (FileNotFoundException e) {
            System.out.println("Insert a valid file name");
        }
        return incorrectWordList;
    }
    
	public Set<String> getSuggestions(String word) {
        
        HashSet <String> suggestionSet = new HashSet <>();
        String revisedWord = word.toLowerCase();
        for (int i = 0; i < revisedWord.length(); i++) {
                    char c = revisedWord.charAt(i);
                    if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') &&
                        !(c >= '0' && c <= '9')) {
                        revisedWord.replace(String.valueOf(c), "");
                    }
        }
        
        if (revisedWord != "") {
            
            // case 1: add 1 character
            for (char c = 'a'; c <= 'z'; c++) {
                for (int i = 0; i < revisedWord.length() + 1; i++) {
                    StringBuilder sb = new StringBuilder (revisedWord);
                    sb.insert(i, c);
                    String possibleWord = sb.toString();
                    
                    if (dictionary.contains(possibleWord)) {
                        suggestionSet.add(possibleWord);
                    }
                }
            }
        
            // case 2: remove 1 character
            for (int i = 0; i < revisedWord.length(); i++) {
                StringBuilder sb = new StringBuilder (revisedWord);
                sb.deleteCharAt(i);
                String possibleWordOne = sb.toString();
                
                if (dictionary.contains(possibleWordOne)) {
                    suggestionSet.add(possibleWordOne);
                }
            }
        
            // case 3: swap adjacent characters
            for (int i = 0; i < revisedWord.length() - 1; i++) {
                StringBuilder sb = new StringBuilder(revisedWord);
                char c = sb.charAt(i);
                sb.setCharAt (i, sb.charAt(i + 1));
                sb.setCharAt (i + 1, c);
                String possibleWordTwo = sb.toString();
                
                if (dictionary.contains(possibleWordTwo)) {
                    suggestionSet.add(possibleWordTwo);
                }
            } 
        }
        return suggestionSet;
    }
} // end of class
