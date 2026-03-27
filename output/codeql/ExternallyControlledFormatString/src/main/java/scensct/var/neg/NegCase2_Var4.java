// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase2_Var4 {
    // Variant 4: Control-flow variation that does not affect reachability.
    public static void main(String[] args) {
        String safeFormat = "Value: %s";
        String taintedArg = null;
        if (args.length > 0) {
            taintedArg = args[0];
        } else {
            taintedArg = "default"; // still safe, but taintedArg is from args if present
        }
        // taintedArg is tainted when args[0] exists, but format string is safe.
        String res = String.format(safeFormat, taintedArg);
        System.out.println(res);
    }
}