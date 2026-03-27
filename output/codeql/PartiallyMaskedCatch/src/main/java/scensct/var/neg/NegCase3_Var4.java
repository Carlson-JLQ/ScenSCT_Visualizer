// A try statement where a catch clause catching a supertype (masking) precedes a catch clause catching its subtype (masked), but the try block cannot throw any exception that propagates to these catch clauses should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        // Variant 4: Inline the dummy method and wrap in a try-with-resources (unrelated)
        try (java.io.StringReader reader = new java.io.StringReader("test")) {
            // reading but no exception thrown
            reader.read();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}