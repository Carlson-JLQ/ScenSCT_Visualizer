// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.var.neg;

public class NegCase3_Var4 {
    static void logMessage(String msg) {
        System.out.println(msg);
    }
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            logMessage("Hello %s");
        } else {
            // dead branch
            logMessage("unused");
        }
    }
}