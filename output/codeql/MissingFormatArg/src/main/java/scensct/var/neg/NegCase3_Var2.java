// A non-format method call with enclosing String parameter but no Object[] should not be flagged.
package scensct.var.neg;

public class NegCase3_Var2 {
    static void logMessage(String msg) {
        System.out.println(msg);
    }
    private static String makeMessage() {
        return "Hello %s";
    }
    public static void main(String[] args) {
        logMessage(makeMessage());
    }
}