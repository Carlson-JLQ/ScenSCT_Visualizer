// Synchronizing on a String type should be flagged as a violation.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        String lock = "lock";
        synchronized (lock) { // Lock expression is a String // [REPORTED LINE]
            System.out.println("Inside synchronized block");
        }
    }
}