// The format string argument in a String.format call originates from a non-user-provided source should not be flagged as a format string vulnerability.
package scensct.var.neg;

public class NegCase3_Var5 {
    // Variant 5: Idiomatic variation - using formatted method of String
    public static void main(String[] args) {
        final String CONSTANT_FORMAT = "Constant: %d";
        int value = 42;
        // Equivalent formatting via String.formatted (Java 15+)
        String result = CONSTANT_FORMAT.formatted(value);
        System.out.println(result);
    }
}