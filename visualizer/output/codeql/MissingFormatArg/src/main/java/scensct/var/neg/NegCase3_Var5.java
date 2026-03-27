// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.var.neg;

public class NegCase3_Var5 {
    static void logMessage(String msg) {
        System.err.println(msg); // changed from System.out
    }
    public static void main(String[] args) {
        logMessage("Hello %s");
    }
}