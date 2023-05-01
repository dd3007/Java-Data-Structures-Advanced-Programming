//*************************************************************************
// Subject: SpellCheckerTester class
// Name: Dani Dassum, dd3007
// Date: 08/03/2021
//*************************************************************************
import java.io.*;
import java.util.*;

public class SpellCheckerTester {
    
    public static void main (String[] args) {
        SpellChecker tester = new SpellChecker("words.txt");
        
        List <String> incorrectWords = tester.getIncorrectWords("test.txt");
        for (String element : incorrectWords){
            System.out.println(element);
        }
        
        Set <String> suggestionsOne = tester.getSuggestions("istant");
        System.out.println(suggestionsOne);
        
        Set <String> suggestionsTwo = tester.getSuggestions("rapidd");
        System.out.println(suggestionsTwo);
        
        Set <String> suggestionsThree = tester.getSuggestions("crzay");
        System.out.println(suggestionsThree);
    }
} // end of class
