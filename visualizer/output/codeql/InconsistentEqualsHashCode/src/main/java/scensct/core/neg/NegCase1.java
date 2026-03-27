// A class that does not override equals(Object) and does not override hashCode() should not be flagged as violating the equals-hashCode contract.
package scensct.core.neg;

public class NegCase1 {
    // This class intentionally does not override equals or hashCode.
    // It relies on the default Object implementations, which is valid.
    private int value;
    
    public NegCase1(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}