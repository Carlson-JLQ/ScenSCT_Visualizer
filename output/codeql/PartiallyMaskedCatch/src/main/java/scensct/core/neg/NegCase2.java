// A try statement where a supertype catch precedes a subtype catch, and there exists an exception type that can be thrown from the try block that is not a subtype of the masked (subtype) type should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        try {
            // Try block that can throw Exception (supertype) and IOException (subtype)
            if (args.length > 0) {
                throw new Exception(); // Exception is not a subtype of IOException
            } else {
                throw new java.io.IOException();
            }
        } catch (java.io.IOException e) {
            // First catch: IOException (subtype)
            System.out.println("IOException caught");
        } catch (Exception e) {
            // Second catch: Exception (supertype)
            System.out.println("Exception caught");
        }
    }
}