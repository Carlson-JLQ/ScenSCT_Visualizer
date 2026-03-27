// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: lock from a static field, with a conditional that always passes
        final Integer lock = Integer.valueOf(1);
        boolean flag = true;
        if (flag) {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        }
    }
}