// ******************************************************************
// Subject: BetterBST Class, Extends BinarySearchTree
// Name: Dani Dassum, dd3007
// Date: 07/18/2021
// Source: BST and AVL Weiss code reviewed in class 
// ******************************************************************
import java.util.*;
import java.io.*;

public class BetterBST <T extends Comparable <?super T>> extends BinarySearchTree <T> {
    
    // Constructor
    public BetterBST () {
        root = null;
    }
    
    // public height() invokes a private recursive height() method
    public int height() {
        BinaryNode <T> node = root;
        return height (root);
    }
    
    private int height(BinaryNode <T> root) {
        if (root == null) {
            return -1;
        }
        
        int rtHeight = height(root.right);
        int lftHeight = height (root.left);
        return (rtHeight < lftHeight) ? (lftHeight + 1) : (rtHeight + 1);
    }
    
    private static final int ALLOWED_IMBALANCE = 1;
    
    // public imbalance() invokes a private recursive imbalance() method
    public T imbalance() {
        return imbalance (root);
    }
    
    private T imbalance (BinaryNode <T> node) {
        if (node == null || height(node) == 0) {
            return null;
        }
        
        int rightH = height(node.right);
        int leftH = height(node.left);
        
        if (rightH - leftH > ALLOWED_IMBALANCE 
            || leftH - rightH > ALLOWED_IMBALANCE) {
            T nodeValue = node.data;
            return nodeValue; // Base case for recursion
        }
        
        T leftImbalance = imbalance(node.left);
        T rightImbalance = imbalance(node.right);
        
        if (leftImbalance != null) {
            return leftImbalance;
        }
        else if (rightImbalance != null) {
            return rightImbalance;
        }
        else {
            return null;
        }
    }
    
    // public mallestGreaterThan() invokes its private recursive counterpart
    public T smallestGreaterThan(T t) {
        BinaryNode <T> node = root;
        return smallestGreaterThan (t, t, root);
    }
    
    // inspired in contains() method from BST code reviewed in class
    private T smallestGreaterThan (T t, T min, BinaryNode <T> root) {
        if (root == null) {
            return (min.compareTo(t) == 0) ? null : min;
        }
        
        int compareResult = root.data.compareTo(t);
        
        if (compareResult > 0) {
            min = root.data;
            return smallestGreaterThan (t, min, root.left);
        }
        else if (compareResult < 0) {
            return smallestGreaterThan (t, min, root.right);
        }
        else if (compareResult == 0) {
            return smallestGreaterThan (t, min, root.right);
        }
        else {
            return min;
        }
    }
    
    // public mirror() invokes private recursive mirror() method
    public BinarySearchTree <T> mirror() {
        BetterBST <T> mirrorTree = new BetterBST <>(); // new BetterBST to mirror
        mirrorTree.insert(root.data);
        return mirror (mirrorTree, root);
    }
    
    private BinarySearchTree <T> mirror (BinarySearchTree <T> tree, BinaryNode <T> root){
        if (root == null) {
            return tree;
        }
        
        mirrorInsert (root.data, tree.root); // calls helper method
        
        if (root.left != null) {
            mirror(tree, root.left);
        }
        if (root.right != null) {
            mirror (tree, root.right);
        }
        return tree;
    }
    
    // For mirrorInsert(), I copied and flipped the original insert() method 
    // from the BST class (changed < and > conditions)
    private BinaryNode <T> mirrorInsert (T x, BinaryNode<T> t) {
        
        if( t == null ) {
            return new BinaryNode<T>( x, null, null );
        }
        
        int compareResult = x.compareTo(t.data);
            
        if (compareResult > 0) {
            t.left = mirrorInsert(x, t.left);
        }
        else if (compareResult < 0) {
            t.right = mirrorInsert(x, t.right);
        }
        else {
            ; // Duplicate; do nothing
        }
        return t;
    }     
    
    // public levelOrderTraversal() invokes private levelOrderTraversal ()
    // with root as parameter
    public LinkedList <BinaryNode<T>> levelOrderTraversal() {
        return levelOrderTraversal(root);
    }
    
    @SuppressWarnings("unchecked")
    private LinkedList <BinaryNode<T>> levelOrderTraversal(BinaryNode<T> t) {
        
        Queue <BinaryNode <T>> queue = new LinkedList <>();
        LinkedList <BinaryNode <T>> list = new LinkedList <>();
        
        if (t == null) {
            return null;
        }
        
        queue.add(t);
        
        while (!queue.isEmpty()) {
            
            BinaryNode<T> element = queue.remove();
            list.add(element);
            
            if (element.left != null) {
                queue.add(element.left);
            }
            if (element.right != null) {
                queue.add(element.right);
            }
        }
        
        return list;
    }
    
} // end of class
