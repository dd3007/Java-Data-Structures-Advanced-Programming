// ************************************************************
// Subject: TwoStackQueue, Implements TwoStackQueueInterface
// Name: Dani Dassum, dd3007
// Date: 07/15/2021
// ************************************************************
import java.util.*;

public class TwoStackQueue <T> implements TwoStackQueueInterface <T> {

    private MyStack <T> s1;
    private MyStack <T> s2;
    
    // Constructor
    public TwoStackQueue() {
    
        s1 = new MyStack <T>();
        s2 = new MyStack <T>();
    }
    
    // enqueue method --> happens by pushing data on to stack 1
    public void enqueue(T x) {
    
        if (s2.isEmpty()) {
            s1.push(x);
        }
        else if (!s2.isEmpty()) {
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            s1.push(x);
        }
    }
    
    // dequeue method --> happens by popping data from stack 2
	public T dequeue() {
    
        if (s1.isEmpty()) {
            if (s2.isEmpty()) {
                throw new NoSuchElementException ("No items in Queue!");
            }
        }
        else if (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    // size method --> returns the size of the queue
	public int size() {
        
        int theSize = s1.size() + s2.size();
        return theSize;
    }
    
    // isEmpty method --> tells us if the queue is open or not
    
	public boolean isEmpty() {
    
        if (s1.isEmpty() && s2.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
    
} // end of class
