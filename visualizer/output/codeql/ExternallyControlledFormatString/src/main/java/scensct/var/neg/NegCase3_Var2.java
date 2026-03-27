// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase3_Var2 {
    // Variant 2: Intra-procedural refactoring - constant built via concatenation
    public static void main(String[] args) {
        final String PREFIX = "Constant: ";
        final String FORMAT = PREFIX + "%d"; // Still compile-time constant
        int value = 42;
        String result = String.format(FORMAT, value);
        System.out.println(result);
    }
}