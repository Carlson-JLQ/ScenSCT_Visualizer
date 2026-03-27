// A try statement where a supertype catch precedes a subtype catch, but every exception type that could be thrown and is a subtype of the masked type is already caught by a catch clause that appears before the masked clause should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        // Variant 3: Extracted method containing the try-catch
        handleTryBlock();
    }
    
    private static void handleTryBlock() {
        try {
            // Only throws IOException
            throw new java.io.IOException();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}