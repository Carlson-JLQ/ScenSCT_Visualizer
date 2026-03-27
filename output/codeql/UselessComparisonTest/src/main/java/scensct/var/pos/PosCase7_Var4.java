// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.var.pos;

public class PosCase7_Var4 {
    // Variant 4: Extract the check into a separate method, use different exception type
    public static void main(String[] args) {
        validate(100);
    }
    
    private static void validate(int param) {
        if (param > 200) { // Always false when called with 100
            throw new UnsupportedOperationException("Invalid param");
        }
    }
}