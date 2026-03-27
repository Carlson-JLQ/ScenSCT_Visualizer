// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.var.neg;

public class NegCase3_Var3 {
    static void logMessage(String msg) {
        System.out.println(msg);
    }
    public static void main(String[] args) {
        String original = "Hello %s";
        String alias = original;
        try {
            logMessage(alias);
        } catch (Exception e) {
            // never reached
        }
    }
}