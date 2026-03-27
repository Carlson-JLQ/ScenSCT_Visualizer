// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.var.neg;

public class NegCase9_Var5 {
    public static void main(String[] args) {
        Object local = null;
        // Use switch-expression-like logic (Java 14+ compatible)
        switch (args.length > 0 ? 1 : 0) {
            case 1:
                // then block
                break;
            default:
                if (args.length < 0) {
                    local = new Object();
                }
                System.out.println(local.toString());
                break;
        }
    }
}