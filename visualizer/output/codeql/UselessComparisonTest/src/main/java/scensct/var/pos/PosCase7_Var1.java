// If condition with non-trivial constant analysis (range), not increment/overflow type, then branch is a throw (not ConcurrentModificationException).
package scensct.var.pos;

public class PosCase7_Var1 {
    // Variant 1: Extract constant to a method, rename variable, restructure if-else
    public static void main(String[] args) {
        int value = getMaxValue();
        boolean condition = value > 200; // Always false
        if (condition) {
            throw new IllegalStateException("value exceeds limit");
        } else {
            System.out.println("OK");
        }
    }
    
    private static int getMaxValue() {
        return 100;
    }
}