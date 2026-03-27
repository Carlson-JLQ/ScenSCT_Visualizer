// Synchronizing on a String type should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var5 {
    private String instanceLock = "lock";

    public static void main(String[] args) {
        PosCase2_Var5 instance = new PosCase2_Var5();
        synchronized (instance.instanceLock) { // [REPORTED LINE]
            System.out.println("Inside synchronized block");
        }
    }
}