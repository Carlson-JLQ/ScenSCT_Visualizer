// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Nested try-catch, but outer catches preserve the original order
        try {
            try {
                if (args.length > 0) {
                    throw new Exception();
                } else {
                    throw new java.io.IOException();
                }
            } catch (java.io.IOException e) {
                System.out.println("Inner IOException caught");
                throw e; // rethrow to outer
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}