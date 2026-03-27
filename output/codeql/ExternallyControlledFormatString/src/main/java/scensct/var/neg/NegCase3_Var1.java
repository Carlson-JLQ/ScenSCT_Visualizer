// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase3_Var1 {
    // Variant 1: Lexical refactoring - constant defined as static final field
    private static final String STATIC_FORMAT = "Constant: %d";
    
    public static void main(String[] args) {
        int value = 42;
        String result = String.format(STATIC_FORMAT, value);
        System.out.println(result);
    }
}