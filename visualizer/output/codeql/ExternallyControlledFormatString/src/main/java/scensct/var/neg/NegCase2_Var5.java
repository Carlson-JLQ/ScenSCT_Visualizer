// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase2_Var5 {
    // Variant 5: Introduce try-catch block around the formatting (no effect on taint).
    public static void main(String[] args) {
        String fmt = "Value: %s";
        String input = args[0];
        try {
            String result = String.format(fmt, input);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}