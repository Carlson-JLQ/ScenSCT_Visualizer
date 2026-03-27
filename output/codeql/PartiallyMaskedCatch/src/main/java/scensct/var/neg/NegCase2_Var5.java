// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Using a different supertype-subtype pair (RuntimeException/IllegalArgumentException)
        // but same logical pattern: subtype caught before supertype, both throwable from try
        try {
            if (args.length > 0) {
                throw new RuntimeException();
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        }
    }
}