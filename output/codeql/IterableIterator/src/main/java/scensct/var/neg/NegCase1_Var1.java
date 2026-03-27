// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Still does not implement Iterable; checker should stay silent.
    private int data;
    
    public NegCase1_Var1(int initial) {
        data = initial;
    }
    
    public int getValue() {
        return data;
    }
    
    // Added unrelated helper that does not create an iterator
    public void printData() {
        System.out.println("Data: " + data);
    }
}