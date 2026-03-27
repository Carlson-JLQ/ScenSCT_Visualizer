// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase6_Var1 {
    // Variant 1: Throw a subtype of IOException, still caught by same catch
    public static void main(String[] args) {
        try {
            throw new java.io.FileNotFoundException(); // subtype of IOException
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        }
    }
}