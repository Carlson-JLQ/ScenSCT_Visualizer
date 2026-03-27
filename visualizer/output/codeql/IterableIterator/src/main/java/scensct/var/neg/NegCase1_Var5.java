// A class that does not implement Iterable should not be flagged as lacking a guard for multiple concurrent iterations.
package scensct.var.neg;

public class NegCase1_Var5 {
    private int value;
    
    public NegCase1_Var5(int v) {
        this.value = v;
    }
    
    public int getValue() {
        try {
            if (value < 0) {
                throw new IllegalArgumentException("negative");
            }
            return value;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
    
    // A method that returns a custom object but not an Iterator
    public Holder getHolder() {
        return new Holder(value);
    }
    
    static class Holder {
        private final int val;
        Holder(int v) { val = v; }
        public int getVal() { return val; }
    }
}