// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: lock obtained via autoboxing, used in a loop
        Integer lock = 1;
        for (int i = 0; i < 1; i++) {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        }
    }
}