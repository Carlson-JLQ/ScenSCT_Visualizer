// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Extracted try-catch into a helper method, with same semantics
        handlePotentialIO();
    }
    
    private static void handlePotentialIO() {
        try {
            // Call a method that declares but does not throw
            safeIOMethod();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
    
    private static void safeIOMethod() throws java.io.IOException {
        // Still no exception thrown
        if (System.currentTimeMillis() > 0) {
            // trivial condition that's always true, but no throw
            return;
        }
    }
}