// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase6_Var5 {
    // Variant 5: Use try-with-resources that throws IOException
    public static void main(String[] args) throws java.io.IOException {
        try (java.io.StringReader reader = new java.io.StringReader("test")) {
            throw new java.io.IOException();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        }
    }
}