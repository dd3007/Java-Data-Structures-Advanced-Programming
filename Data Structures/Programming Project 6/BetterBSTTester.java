// ******************************************************************
// Subject: BetterBSTTester class
// Name: Dani Dassum, dd3007
// Date: 07/18/2021
// ******************************************************************
import java.util.*;
import java.io.*;

public class BetterBSTTester {
    
    public static void main (String[] args) {
        System.out.println("******************************************");
        System.out.println("Welcome to the BetterBST Tester!");
        System.out.println("BST Inserts: 5, 7, 2, 1, 3, 9, 10, 11");
        
        BetterBST <Integer> bst = new BetterBST <>();
        
        bst.insert(5);
        bst.insert(7);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(9);
        bst.insert(10);
        bst.insert(11);
        
        System.out.println("******** TEST 1: height() *********");
        System.out.println(bst.height()); // expected: 4
        
        System.out.println("******** TEST 2: imbalance() *********");
        System.out.println(bst.imbalance()); // expected: 9
        
        System.out.println("******** TEST 3: smallestGreaterThan(T t) *********");
        System.out.println(bst.smallestGreaterThan(1)); // expected: 2
        System.out.println(bst.smallestGreaterThan(2)); // expected: 3
        System.out.println(bst.smallestGreaterThan(5)); // expected: 7
        System.out.println(bst.smallestGreaterThan(10)); // expected: 11
        System.out.println(bst.smallestGreaterThan(20)); // expected: null
        
        System.out.println("******** TEST 4: mirror() *********");
        System.out.println(bst.mirror());
        
        System.out.println("******** TEST 5: levelOrderTraversal() *********");
        System.out.println(bst.levelOrderTraversal());
    }
    
}
