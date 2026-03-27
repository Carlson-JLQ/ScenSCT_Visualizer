// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Using a record-like pattern with a companion factory
    private final int value;
    
    private NegCase1_Var5(int value) {
        this.value = value;
    }
    
    public static NegCase1_Var5 of(int val) {
        if (val < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
        return new NegCase1_Var5(val);
    }
    
    public int getValue() {
        return value;
    }
    
    // Override equals/hashCode to add complexity
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NegCase1_Var5)) return false;
        NegCase1_Var5 other = (NegCase1_Var5) o;
        return this.value == other.value;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}