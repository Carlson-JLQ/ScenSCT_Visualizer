// A method call that uses a format string argument but is not a call to String.format should not be flagged as a format string vulnerability.
package scensct.var.neg;

import java.util.Formatter;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - introduce a temporary and conditional flow.
        String tainted = args.length > 0 ? args[0] : "default";
        Formatter f = null;
        if (tainted != null) {
            f = new Formatter();
            f.format(tainted, "safeArg");
        }
        if (f != null) {
            System.out.println(f.toString());
        }
    }
}