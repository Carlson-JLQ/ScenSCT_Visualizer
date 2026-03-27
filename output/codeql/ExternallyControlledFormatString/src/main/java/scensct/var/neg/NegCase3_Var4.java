// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase3_Var4 {
    // Variant 4: Control flow restructuring - constant chosen via ternary operator
    public static void main(String[] args) {
        boolean flag = true;
        final String FORMAT = flag ? "Constant: %d" : "Other: %d"; // Both branches are constants
        int value = 42;
        String result = String.format(FORMAT, value);
        System.out.println(result);
    }
}