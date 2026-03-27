// Nested call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase3_Var1 {
    static void someMethod(boolean b) {
        // Dummy method to nest the equals call
    }
    public static void main(String[] args) {
        // Introduce an alias via a local variable for the receiver
        StringBuilder builder = new StringBuilder();
        StringBuilder sb = builder; // Aliasing
        Thread t = new Thread();
        // Call remains nested, but with aliased receiver
        someMethod(sb.equals(t)); // [REPORTED LINE]
    }
}