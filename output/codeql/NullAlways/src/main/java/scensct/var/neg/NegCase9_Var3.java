// Dereference exists but not in the specific basic block under analysis should not be flagged as always null.
package scensct.var.neg;

public class NegCase9_Var3 {
    public static void main(String[] args) {
        Object local = null;
        // Restructure with a loop that runs at most once
        int i = 0;
        do {
            if (args.length > 0) {
                break;
            }
            if (args.length < 0) {
                local = new Object();
            }
            System.out.println(local.toString());
            i++;
        } while (i < 1);
    }
}