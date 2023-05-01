//*************************************************************************
// Subject: KBestCounterTester class
// Name: Dani Dassum, dd3007
// Date: 08/03/2021
//*************************************************************************
import java.io.*;
import java.util.*;

public class KBestCounterTester {
    
    public static void main (String[] args) {
        
        KBestCounter kbc = new KBestCounter <>(10);
        PriorityQueue tester = new PriorityQueue <>(); 
        
        kbc.count(5);
        kbc.count(4);
        kbc.count(9);
        kbc.count(2);
        kbc.count(1);
        
        List <Integer> list = kbc.kbest();
        System.out.println(list);
    }
} // end of class
