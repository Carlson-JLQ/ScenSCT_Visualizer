// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase2_Var2 {
    // Variant 2: Intra-procedural restructuring with temporary and explicit local.
    public static void main(String[] args) {
        String tainted = args[0];
        String formatString;
        {
            formatString = "Value: %s";
        }
        String formattedResult = String.format(formatString, tainted);
        System.out.println(formattedResult);
    }
}