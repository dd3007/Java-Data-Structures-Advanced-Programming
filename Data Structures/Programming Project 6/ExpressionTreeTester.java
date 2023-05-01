// ******************************************************************
// Subject: ExpressionTreeTester Class
// Name: Dani Dassum, dd3007
// Date: 07/18/2021
// ******************************************************************
import java.util.Scanner;

public class ExpressionTreeTester {
    
    public static void main (String[] args) {
    
        System.out.println("******************************************");
        System.out.println("Welcome to the Expression Tree Tester!");
        System.out.println("Type in the expression you'd like to use");
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        
        ExpressionTree et = new ExpressionTree(expression);
        
        System.out.println("******** TEST 1: eval() *********");
        System.out.println(et.eval());
        
        System.out.println("******** TEST 2: postfix() *********");
        System.out.println(et.postfix());
        
        System.out.println("******** TEST 3: prefix() *********");
        System.out.println(et.prefix());
        
        System.out.println("******** TEST 4: infix() *********");
        System.out.println(et.infix());
    }
}
