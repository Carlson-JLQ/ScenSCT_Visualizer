// Unbraced then branch with same-line further indented successor should be flagged as positive.
package scensct.var.pos;

public class PosCase5_Var2 {
    public static void main(String[] args) {
        boolean flag = Boolean.parseBoolean("true");
        if (flag)
            logMessage("Then branch"); // [REPORTED LINE]
            logMessage("Misleading successor"); // Indented further, but not part of branch
    }
    
    private static void logMessage(String msg) {
        System.out.println(msg);
    }
}