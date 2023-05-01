// ************************************************************
// Subject: SymbolBalance Class, Implements SymbolBalanceInterface
// Name: Dani Dassum, dd3007
// Date: 07/15/2021
// Sources:
// - Switch-Case statement: https://www.w3schools.com/java/java_switch.asp
// - Scanner: https://docs.oracle.com/javase/8/docs/api/
// ************************************************************
import java.io.*;
import java.util.*;

public class SymbolBalance implements SymbolBalanceInterface {
    
    private MyStack <Character> bracketStack;
    private File fileToReview;
    private Scanner scanner;
    
    // To test tester files --> here's the main method of the class:
    
    public static void main (String[] args) {
        
        SymbolBalance tester = new SymbolBalance();
        
        // Test 1
        System.out.println("***** TEST 1 *****");
        tester.setFile("TestFiles/Test1.java");
        System.out.println(tester.checkFile());
        
        // Test 2
        System.out.println("***** TEST 2 *****");
        tester.setFile("TestFiles/Test2.java");
        System.out.println(tester.checkFile());
        
        // Test 3
        System.out.println("***** TEST 3 *****");
        tester.setFile("TestFiles/Test3.java");
        System.out.println(tester.checkFile());
        
        // Test 4
        System.out.println("***** TEST 4 *****");
        tester.setFile("TestFiles/Test4.java");
        System.out.println(tester.checkFile());
        
        // Test 5
        System.out.println("***** TEST 5 *****");
        tester.setFile("TestFiles/Test5.java");
        System.out.println(tester.checkFile());
        
        // Test 6
        System.out.println("***** TEST 6 *****");
        tester.setFile("TestFiles/Test6.java");
        System.out.println(tester.checkFile());
    }
    
    // Should take in a String representing the path 
    // to the file that should be checked
    
    public void setFile(String filename) {
        
        try {
            fileToReview = new File(filename);
            scanner = new Scanner (fileToReview);
        }
        catch (FileNotFoundException e) {
            System.out.println ("There is no such file");
        }
    }
    
    // Checks files for Balance Errors;
    
	public BalanceError checkFile() {
        
        bracketStack = new MyStack <Character> ();
        bracketStack.doClear();
        
        boolean quoteOne = false; // boolean for whether quote "" is open or not
        boolean quoteTwo = false; // for whether quote /* */ is open or not
        int lineNumber = 0;
        String line;
        char popped = '0'; // first mismatch symbol (f.e. ( in (}) )
        char erased = '0'; // last item to be popped from the bracketStack
        char prevChar = '0'; // previous character from currentSymbol
        char nextChar = '0'; // next character from currentSymbol
        
        while (scanner.hasNextLine()) { // to iterate through document
            line = scanner.nextLine();
            lineNumber++;
            
            for (int i = 0; i < line.length(); i++) { // to iterate through line
                char currentSymbol = line.charAt(i);
                if (i < line.length() - 1) {
                    nextChar = line.charAt(i+1); // new nextChar declaration
                }
                if (i > 0) {
                    prevChar = line.charAt(i-1); // new prevChar declaration
                }

                switch (currentSymbol) {
                
                // analysis for the different values currentSymbol can take:
                // (, {, [, ", *, ], }, ) by case (using switch-case statement)
                        
                    case '(':
                        if (quoteOne == false && quoteTwo == false) {
                            bracketStack.push(currentSymbol);
                            break;
                        }
                        else {
                            break;
                        }
                        
                    case '{':
                        if (quoteOne == false && quoteTwo == false) {
                            bracketStack.push(currentSymbol);
                            break;
                        }
                        else {
                            break;
                        }
                        
                    case '[':
                        if (quoteOne == false && quoteTwo == false) {
                            bracketStack.push(currentSymbol);
                            break;
                        }
                        else {
                            break;
                        }

                    case '"':
                        if (quoteTwo == false) {
                            if (quoteOne == false) {
                                quoteOne = true;
                                bracketStack.push(currentSymbol);
                                break;
                            }
                            else if (quoteOne == true) {
                                quoteOne = false;
                                erased = bracketStack.pop();
                                System.out.println 
                                ("last erased character: " + erased);
                                break;
                            }
                        }
                        else {
                            break;
                        }

                    case '*':
                        if (quoteOne == false) {
                            if (i > 0) {
                                if (prevChar == '/') {
                                    if (quoteTwo == false){
                                        quoteTwo = true;
                                        bracketStack.push(currentSymbol);
                                        break;
                                    }
                                    else if (quoteTwo == true){
                                        break;
                                    }
                                }
                            }
                            if (i < line.length() - 1) {
                                if (nextChar == '/') {
                                    if (quoteTwo == true) {
                                        quoteTwo = false;
                                        erased = bracketStack.pop();
                                        System.out.println 
                                        ("last erased character: " + erased);
                                        break;
                                    }
                                    else if (quoteTwo == false) {
                                        return new EmptyStackError (lineNumber);
                                    }
                                }
                            }
                        }
                        else {
                            break;
                        }

                    case ')':
                        if (quoteTwo == false && quoteOne == false) {
                            if (bracketStack.size() == 0) {
                                return new EmptyStackError (lineNumber);
                            }
                            char stackTop = bracketStack.peek();
                            if (!bracketStack.isEmpty()) {
                                if (currentSymbol == ')' && stackTop != '(') {
                                    popped = stackTop;
                                    return new MismatchError 
                                    (lineNumber, currentSymbol, popped);
                                }
                                else {
                                    erased = bracketStack.pop();
                                    System.out.println 
                                    ("last erased character: " + erased);
                                    break;
                                }
                            }
                            else {
                                return new EmptyStackError (lineNumber);
                            }
                        }
                        else {
                            break;
                        }

                    case '}':
                        if (quoteTwo == false && quoteOne == false) { 
                            if (bracketStack.size() == 0) {
                                return new EmptyStackError (lineNumber);
                            }
                            char stackTop = bracketStack.peek();
                            if (!bracketStack.isEmpty()) {
                                if (currentSymbol == '}' && stackTop != '{') {
                                    popped = stackTop;
                                    return new MismatchError 
                                    (lineNumber, currentSymbol, popped);
                                }
                                else {
                                    erased = bracketStack.pop();
                                    System.out.println 
                                    ("last erased character: " + erased);
                                    break;
                                }
                            }
                            else {
                                return new EmptyStackError (lineNumber);
                            }
                        }
                        else {
                            break;
                        }

                    case ']':
                        if (quoteTwo == false && quoteOne == false) {
                            if (bracketStack.size() == 0) {
                                return new EmptyStackError (lineNumber);
                            }
                            char stackTop = bracketStack.peek();
                            if (!bracketStack.isEmpty()) {
                                if (currentSymbol == ']' && stackTop != '[') {
                                    popped = stackTop;
                                    return new MismatchError 
                                    (lineNumber, currentSymbol, popped);
                                }
                                else {
                                    erased = bracketStack.pop();
                                    System.out.println 
                                    ("last erased character: " + erased);
                                    break;
                                }
                            }
                            else {
                                return new EmptyStackError (lineNumber);
                            }
                        }
                        else {
                            break;
                        }
                }

            }
        }
        
        if (!bracketStack.isEmpty()) {
            int stackSize = bracketStack.size();
            char stackTop = bracketStack.peek();
            return new NonEmptyStackError (stackTop, stackSize);
        }
        return null;
    }

} // end of class
