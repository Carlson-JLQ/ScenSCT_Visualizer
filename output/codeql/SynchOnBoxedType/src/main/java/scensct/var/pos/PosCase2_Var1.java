// Synchronizing on a String type should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var1 {
    private static final String GLOBAL_LOCK = "global";

    public static void main(String[] args) {
        String lock = GLOBAL_LOCK;
        if (lock != null) {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        }
    }
}