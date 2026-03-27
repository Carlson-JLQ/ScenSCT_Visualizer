// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Variant 5: Split catch blocks across a conditional wrapper, but same try block
        Runnable r = () -> {
            try {
                dummyMethod();
            } catch (java.io.IOException e) {
                System.out.println("IOException caught");
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        };
        r.run();
    }
    
    private static void dummyMethod() throws java.io.IOException {
        // nothing
    }
}