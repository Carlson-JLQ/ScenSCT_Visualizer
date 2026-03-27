// A call to String.format where a tainted value is passed as a substitution argument, not as the format string argument should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase2_Var3 {
    // Variant 3: Inter-procedural refactoring — helper method returns constant format.
    private static String getFormat() {
        return "Value: %s";
    }
    
    public static void main(String[] args) {
        String substitution = args[0];
        String result = String.format(getFormat(), substitution);
        System.out.println(result);
    }
}