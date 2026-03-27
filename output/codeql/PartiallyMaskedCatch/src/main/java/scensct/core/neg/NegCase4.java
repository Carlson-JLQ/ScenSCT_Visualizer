// A try statement where a supertype catch precedes a subtype catch, but every exception type that could be thrown and is a subtype of the masked type is already caught by a catch clause that appears before the masked clause should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        try {
            // Try block that can throw only IOException
            throw new java.io.IOException();
        } catch (java.io.IOException e) {
            // First catch: IOException (subtype of Exception, caught here)
            System.out.println("IOException caught");
        } catch (Exception e) {
            // Second catch: Exception (supertype), but IOException already caught, so not masked
            System.out.println("Exception caught");
        }
    }
}