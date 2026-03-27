// Synchronizing on a boxed primitive type (Integer) should be flagged as a violation.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        Integer lock = Integer.valueOf(1);
        synchronized (lock) { // Lock expression is a boxed primitive (Integer) // [REPORTED LINE]
            System.out.println("Inside synchronized block");
        }
    }
}