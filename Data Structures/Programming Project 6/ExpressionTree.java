// *****************************************************************************************
// Subject: ExpressionTree Class, Implements ExpressionTreeInterface
// Name: Dani Dassum, dd3007
// Date: 07/18/2021
// Sources: I based this code on the Expression Tree algorithm and Weiss code
// In order to separate the String 'expression', I used the java split() method,
// using white space as the indicator to separate string 
// (https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#split(java.lang.String))
// ******************************************************************************************
import java.util.*;
import java.io.*;

public class ExpressionTree <T> implements ExpressionTreeInterface {
    
    private ExpressionNode root; // ExpressionTree has only 1 instance variable
        
    // Constructor: runs stack based algorithm to build an expression tree    
    public ExpressionTree (String expression) { // expression is post-fix one
        
        Stack <ExpressionNode> stack = new Stack <>();
        String [] operationsArray = expression.split(" ");
        
        
        for (String item : operationsArray) {
            
            // Building operator nodes
            if (item.equals ("+") || item.equals ("-") ||
                item.equals ("/") || item.equals ("*")) {
                ExpressionNode operatorNode = new ExpressionNode 
                    (item, null, null);
        
                // Pushing operator nodes onto stack, after children assignment
                if (!stack.isEmpty()) {
                    operatorNode.right = stack.pop(); // right child first
                }
                else {
                    throw new EmptyStackException();
                }

                if (!stack.isEmpty()) {
                    operatorNode.left = stack.pop(); //left child second
                }
                else {
                    throw new EmptyStackException();
                }

                stack.push(operatorNode);
            }
            
            // Building and pushing operand nodes
            else {
                ExpressionNode operandNode = new ExpressionNode 
                (Integer.parseInt(item));
                stack.push(operandNode);
            }
        }
        root = stack.pop(); // we pop the root to get expression tree
        
        if (!stack.isEmpty()) {
            throw new RuntimeException();
        }
    }    
    
    // eval() invokes private recursive eval() which takes as parameter the root
    public int eval() {
        return eval (root);
    }
    
    // Based on expression tree code eval() method from Lecture 6
    private int eval (ExpressionNode root) {
        
        if (root.left == null) {
            return root.operand;
        }
        
        int leftNode = eval (root.left);
        int rightNode = eval (root.right);
        return apply (root.operator, leftNode, rightNode);
    }
    
    // apply() helper method for private recursive eval()
    private int apply (String operator, int left, int right) {
        
        int operation = 0;
        
        if (operator.equals("+")) {
            operation = left + right;
        }
        else if (operator.equals("-")) {
            operation = left - right;
        }
        else if (operator.equals("*")) {
            operation = left * right;
        }
        else if (operator.equals("/")) {
            operation = left / right;
        }
        return operation;
    }
    
    // postfix() invokes private recursive postfix() with root as parameter
	public String postfix() {
        return postfix (root);
    }
    
    private String postfix (ExpressionNode root) {
        
        String postFix = "";
        
        if (root.left == null) { // root is a leaf; by default is an operand
            String operandPost = new String (Integer.toString(root.operand));
            return operandPost;
        }
        
        if (root.operand > -1) {
            postFix = postfix(root.left) + " " + postfix(root.right) + " " 
                + root.operator;
            return postFix;
        }
        else {
            postFix = postfix(root.left) + " " + root.operator + " " 
                + postfix(root.right);
            return postFix;
        }
    }
    
    // prefix() invokes private recursive prefix() with root as parameter
	public String prefix() {
        return prefix (root);
    }
    
    private String prefix (ExpressionNode root) {
        
        String preFix = "";

        if (root.left == null) { // root is a leaf; by default is an operand
            String operandPre = new String (Integer.toString(root.operand));
            return operandPre;
        }
        
        if (root.operand > -1) {
            preFix = root.operator + " " + prefix(root.left) + " " 
                + prefix(root.right);
            return preFix;
        }
        else {
            preFix = prefix(root.left) + " " + root.operator + " " 
                + prefix(root.right);
            return preFix;
        }
    }
    
    // infix() invokes private recursive infix() with root as parameter
	public String infix() {
        return infix (root);
    }
    
    private String infix (ExpressionNode root) {
        
        String inFix = "";
        
        if (root.left == null) { // root is a leaf; by default is an operand
            String operandIn = new String (Integer.toString(root.operand));
            return operandIn;
        }
        
        if (root.operand > -1) {
            inFix = "(" + infix(root.left) + " " + root.operator + " " 
                + infix(root.right) + ")";
            return inFix;
        }
        else {
            inFix = infix(root.left) + " " + root.operator + " " 
                + infix(root.right);
            return inFix;
        }
    }
    
    
 // ********** ExpressionNode nested class **********   
    
    private static class ExpressionNode {
        
        private String operator;
        private int operand;
        private ExpressionNode left;
        private ExpressionNode right;
        
        /* We have two types of ExpressionNodes: operators and operands
           We'll build one constructor for each */
        
        
        // Operator ExpressionNode Constructor
        
        private ExpressionNode (String o, ExpressionNode l, ExpressionNode r){
            
            operator = o;
            left = l;
            right = r;
        }
        
        // Operand ExpressionNode Constructor
        
        private ExpressionNode (int o){
            
            operand = o;
        }
    
    } // end of ExpressionNode class
    
} // end of class
