// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        // Variant 3: Introduce a dummy variable and conditional that never triggers throw
        boolean flag = false;
        try {
            if (flag) {
                throw new java.io.IOException(); // dead code, never executed
            }
            dummyMethod();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
    
    private static void dummyMethod() throws java.io.IOException {
        // no-op
    }
}