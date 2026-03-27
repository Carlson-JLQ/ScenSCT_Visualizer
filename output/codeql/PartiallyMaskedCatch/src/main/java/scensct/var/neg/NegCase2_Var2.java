// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Using a loop to structure the try block, with same throwing logic
        for (int i = 0; i < 1; i++) {
            try {
                if (args.length > i) {
                    throw new Exception();
                }
                throw new java.io.IOException();
            } catch (java.io.IOException e) {
                System.out.println("IOException caught");
                break;
            } catch (Exception e) {
                System.out.println("Exception caught");
                break;
            }
        }
    }
}