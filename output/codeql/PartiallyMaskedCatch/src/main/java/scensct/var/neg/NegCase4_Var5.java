// A try statement where a supertype catch precedes a subtype catch, but every exception type that could be thrown and is a subtype of the masked type is already caught by a catch clause that appears before the masked clause should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Finally block, nested try
        try {
            try {
                throw new java.io.IOException();
            } finally {
                System.out.println("Cleanup");
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}