// ************************************************************
// Subject: MyStack Class, Implements MyStackInterface
// (I got the base for this code from the MyArrayList.java file)
// Name: Dani Dassum, dd3007
// Date: 07/15/2021
// ************************************************************
import java.util.*;

public class MyStack <T> implements MyStackInterface <T> {
    
    private static final int DEF_CAPACITY = 20;
    private T [] array;
    private int size;

    // Constructor for MyStack
    public MyStack () {
        doClear();
    }
    
    // doClear method --> resets array
    public void doClear () {
        size = 0;
        ensureCapacity(DEF_CAPACITY);
    }
    
    // ensureCapacity method --> to grow array as needed when at max capacity
    @SuppressWarnings("unchecked")
    private void ensureCapacity (int newCapacity) {
        if (newCapacity < size) {
            return;
        }
        T [] temp = array;
        array = (T[]) new Object [newCapacity];
        for (int i = 0; i < size(); i++){
            array[i] = temp[i];
        }
    }
    
    // push method --> adds items on top of stack (at end of array)
    public void push(T x) {
        if (array.length == size) {
            ensureCapacity (size * 2 + 1);
        }
        array [size++] = x;
    }
    
    // pop method --> deletes items on top of stack (at end of array)
	public T pop() {
            T temp = peek();
            size--;
            return temp;
    }
    
    // peek method --> reveals the value at top of stack (end of list)
	public T peek() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException ("The stack is empty!");
        }
        else {
            return array [size - 1];
        }
    }
    
    // isEmpty method --> determines whether stack (array) is empty or not;
	public boolean isEmpty() {
        return size () == 0;
    }
    
    // size method --> returns size of stack (filled positions in array)
	public int size() {
        return size;
    }
} // end of class
