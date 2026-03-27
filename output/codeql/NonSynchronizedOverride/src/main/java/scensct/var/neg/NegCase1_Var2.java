// A method that does not override any method should not be flagged as unsynchronized override.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Intra-procedural refactoring - wrap in try-catch-finally
    public void sub() {
        try {
            System.out.println("No override");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Cleanup placeholder
        }
    }
}