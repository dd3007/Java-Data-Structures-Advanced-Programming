//*************************************************************************
// Subject: Problem 3 with Main Method
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************

public class Problem3 {
    
    public static void main(String[] args){
        
        BigO analysis = new BigO();
        
        // Cubic Function Analysis (O(N^3))
        analysis.cubic(1);
        analysis.cubic(2);
        analysis.cubic(3);
        analysis.cubic(4);
        analysis.cubic(5);
        
        System.out.println("********************");
        
        // Exponential Function Analysis (O(2^N))
        analysis.exp(1);
        analysis.exp(2);
        analysis.exp(3);
        analysis.exp(4);
        analysis.exp(5);
        
        System.out.println("********************");
        
        // Constant Function Analysis (O(1))
        analysis.constant(1);
        analysis.constant(2);
        analysis.constant(3);
        analysis.constant(4);
        analysis.constant(5);
    }    
}
