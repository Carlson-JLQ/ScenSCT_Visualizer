// A try statement with at least two catch clauses where the exception type caught by the first clause (masking) is not a strict supertype of the exception type caught by the second clause (masked) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Idiomatic Variation & Lexical Refactoring
    // - Use different unrelated standard exception types (IllegalStateException, IllegalArgumentException).
    // - Change condition to a switch-like structure.
    // - Add a finally block (does not affect catchability).
    public static void main(String[] args) {
        try {
            int code = args.length % 2;
            switch (code) {
                case 0:
                    throw new IllegalStateException("State invalid");
                case 1:
                    throw new IllegalArgumentException("Argument invalid");
                default:
                    // unreachable, but keeps structure
                    throw new RuntimeException();
            }
        } catch (IllegalStateException ise) {
            System.out.println("State exception: " + ise.getMessage());
        } catch (IllegalArgumentException iae) {
            System.out.println("Argument exception: " + iae.getMessage());
        } finally {
            System.out.println("Cleanup done");
        }
    }
}