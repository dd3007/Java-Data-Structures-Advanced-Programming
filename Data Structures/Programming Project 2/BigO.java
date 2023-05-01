//*************************************************************************
// Subject: BigO Class, Implements BigO Interface
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************

public class BigO implements BigOInterface {
    
    // The following fragments were inspired by examples in the textbook

    // cubic big O function method (book page 37, nested loops)
    public void cubic(int n) {
        
        long startTimeCube = System.nanoTime();
        
        int count = 0;
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int l = 0; l < n; l++) {
                    count++;
                }
            }
        }
        
        long endTimeCube = System.nanoTime();
        long totalTimeCube = endTimeCube - startTimeCube;
        System.out.println("Cubic: n -> : " + n + " = " + totalTimeCube + "ns");
    }
    
    
    // cubic big O function method (book page 48 -> Math.pow() idea)
	public void exp(int n) {
        
        long startTimeExp = System.nanoTime();
        
        int count = 0;
        
        for (int i = 0; i < Math.pow(2, n); i++){ // for every n, 2^n and this
            count++;                             // will be the amount of times
        }                                        // the loop is repeated
        
        long endTimeExp = System.nanoTime();
        
        long totalTimeExp = endTimeExp - startTimeExp;
        System.out.println("Exp: n -> : " + n + " = " + totalTimeExp + "ns");
    }
    
    
    // constant big O function method
	public void constant(int n) {
        
        long startTimeCons = System.nanoTime();
        
        int multiplication = (2/5 * n) + 2;
        
        long endTimeCons = System.nanoTime();
        
        long totalTimeCons = endTimeCons - startTimeCons;
        System.out.println("Cons: n = : " + n + " = " + totalTimeCons + "ns");
    }
   
}
