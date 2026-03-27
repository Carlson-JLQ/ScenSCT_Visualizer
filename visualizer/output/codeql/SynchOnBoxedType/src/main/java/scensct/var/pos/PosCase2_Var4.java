// Synchronizing on a String type should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        Object obj = "lock";
        String lock = (String) obj;
        try {
            synchronized (lock) { // [REPORTED LINE]
                System.out.println("Inside synchronized block");
            }
        } finally {
            System.out.println("Cleanup");
        }
    }
}