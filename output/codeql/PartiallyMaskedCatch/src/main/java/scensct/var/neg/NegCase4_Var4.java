// A try statement where a supertype catch precedes a subtype catch, but every exception type that could be thrown and is a subtype of the masked type is already caught by a catch clause that appears before the masked clause should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        // Variant 4: Different specific exception (subtype of IOException), supertype Throwable
        try {
            throw new java.io.FileNotFoundException();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("FileNotFoundException caught");
        } catch (java.io.IOException e) { // [REPORTED LINE]
            System.out.println("IOException caught");
        } catch (Throwable t) {
            System.out.println("Throwable caught");
        }
    }
}