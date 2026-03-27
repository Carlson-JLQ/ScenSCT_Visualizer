// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase6_Var4 {
    // Variant 4: Add a finally block, keep single catch
    public static void main(String[] args) {
        try {
            throw new java.io.IOException();
        } catch (java.io.IOException e) {
            System.out.println("IOException caught");
        } finally {
            System.out.println("Cleanup");
        }
    }
}