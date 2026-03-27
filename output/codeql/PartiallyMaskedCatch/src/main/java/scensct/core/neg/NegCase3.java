// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        try {
            // Dummy call that declares IOException but doesn't throw
            dummyMethod();
        } catch (java.io.IOException e) {
            // First catch: IOException (subtype)
            System.out.println("IOException caught");
        } catch (Exception e) {
            // Second catch: Exception (supertype)
            System.out.println("Exception caught");
        }
    }
    
    private static void dummyMethod() throws java.io.IOException {
        // No actual exception thrown
    }
}