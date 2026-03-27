// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Variant 2: Loop around try-catch, still no exception thrown
        for (int i = 0; i < 1; i++) {
            try {
                dummyMethod();
                break; // ensures loop runs once, no effect on exceptions
            } catch (java.io.IOException e) {
                System.out.println("IOException caught");
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }
    }
    
    private static void dummyMethod() throws java.io.IOException {
        // empty
    }
}