// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        try {
            // Try block that can throw IOException
            throw new java.io.IOException();
        } catch (java.io.IOException e) {
            // Only catch clause: catches IOException, so no masking type at a different index
            System.out.println("IOException caught");
        }
    }
}