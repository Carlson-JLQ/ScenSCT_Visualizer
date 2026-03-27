// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.core.neg;

public class NegCase1 {
    // This class does NOT implement Iterable, so the checker should not analyze it.
    private final int value;
    
    public NegCase1(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}