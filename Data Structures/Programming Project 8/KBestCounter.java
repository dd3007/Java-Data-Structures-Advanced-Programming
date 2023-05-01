//*************************************************************************
// Subject: KBestCounter, implements KBest
// Name: Dani Dassum, dd3007
// Date: 08/03/2021
//*************************************************************************
import java.io.*;
import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T> {
    
    private PriorityQueue <T> maxHeap; // work with maxHeap
    private int values;
    
    // Find the k-best (largest) values in a set of data
    // class keeps track of the k-elements seen so far in a sequence of data
    
    // Constructor of KBestCounter
    public KBestCounter (int k) {
        
        maxHeap = new PriorityQueue <>();
        values = k;
    }
    
    public void count(T x) {
        if (maxHeap.size() < values) {
            maxHeap.add(x);
        }
        else {
            maxHeap.poll();
            maxHeap.add(x);
        }
    }
    
	public List<T> kbest() {
        
        PriorityQueue <T> old = new PriorityQueue <> (values);
        ArrayList <T> newList = new ArrayList <>();
        
        for (T element : maxHeap) {
            old.add(element);
        }
        
        while (old.size() > 0) {
            newList.add(old.poll());
        }
        
        return newList;
    }
} // end of class
