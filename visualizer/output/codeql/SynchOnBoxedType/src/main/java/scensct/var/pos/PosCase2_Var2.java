// Synchronizing on a String type should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        String lock = getLock();
        for (int i = 0; i < 1; i++) {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        }
    }

    private static String getLock() {
        return "lock";
    }
}