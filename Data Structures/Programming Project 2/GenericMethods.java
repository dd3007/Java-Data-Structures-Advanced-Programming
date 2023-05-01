//*************************************************************************
// Subject: GenericMethods Class, Implements GenericMethodsInterface
// Name: Dani Dassum, dd3007
// Date: 07/08/2021
//*************************************************************************

public class GenericMethods implements GenericMethodsInterface {
    
    // Linear Search implementing the Comparable Interface
    // NOTE: I broke down the method signatures not to go over 
    // the 80 characters condition
    
    public <AnyType extends Comparable<AnyType>> 
    int linearSearch(AnyType[] a, AnyType x){
        
        int n;
        int comparison;
            
        for (n = 0; n < a.length - 1; n++){
            comparison = a[n].compareTo(x); // regular Binary Search except
            if (comparison == 0) {          // we implement Comparable Interface
                return n;
            }
        }
        return -1;
    }
    
    // Binary Search + Private Recursive Helper Method
    
    public <AnyType extends Comparable<AnyType>> 
    int binarySearch(AnyType[] a, AnyType x){
        
        int lower = 0;
        int upper = a.length - 1;
        int middle;
        int comparisonTwo;
        
        // only cases to be aware are if upper < upper, which would be an 
        // empty array, and if we have an array of length 1, for which
        // we'd only have to ask if the value a[0] = x
        
        if (lower > upper) {
            return -1;
        }
        if (lower == upper) {
            int comparisonOne = a[0].compareTo(x);
            return comparisonOne;
        }
        else {
            comparisonTwo = recursiveBinary(a, x, upper, lower);
            return comparisonTwo;
        }
    }
    
    private <AnyType extends Comparable<AnyType>> 
    int recursiveBinary (AnyType[] a, AnyType x, int high, int low){
       
        
        while (low <= high) {
            int mid = (high + low)/2;
            int comparison = a[mid].compareTo(x); //Because Comparable Interface
                                                  // was implemented       
            if (comparison > 0) {
                high = mid - 1;
                return recursiveBinary (a, x, high, low); // new value for high
            }
            else if (comparison < 0) {
                low = mid + 1;
                return recursiveBinary (a, x, high, low); // new value for low
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    
}
