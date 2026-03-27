// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Extracted throwing logic to a helper method, with same exception behavior
        try {
            throwBasedOnArgs(args);
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }

    private static void throwBasedOnArgs(String[] args) throws Exception {
        if (args.length > 0) {
            throw new Exception();
        } else {
            throw new java.io.IOException();
        }
    }
}