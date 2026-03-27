// A try statement where a supertype catch precedes a subtype catch, but every exception type that could be thrown and is a subtype of the masked type is already caught by a catch clause that appears before the masked clause should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Method call that throws IOException, conditional always true
        if (args.length >= 0) { // always true
            try {
                throwIOException();
            } catch (java.io.IOException e) {
                System.out.println("IOException caught");
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }
    }
    
    private static void throwIOException() throws java.io.IOException {
        throw new java.io.IOException("file not found");
    }
}