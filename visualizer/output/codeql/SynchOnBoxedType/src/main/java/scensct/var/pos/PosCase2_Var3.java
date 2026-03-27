// Synchronizing on a String type should be flagged as a violation.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        String[] locks = new String[]{"lock"};
        synchronized (locks[0]) { // [REPORTED LINE]
            System.out.println("Inside synchronized block");
        }
    }
}