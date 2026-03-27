// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.core.neg;

public class NegCase1 {
    // This class does not implement Iterable, so the checker should not report.
    private int value;
    
    public NegCase1(int v) {
        value = v;
    }
    
    public int getValue() {
        return value;
    }
}