// A try statement with at least one catch clause, where a given exception type (masking) is not the type caught by the catch clause at a specified index (first) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase6_Var3 {
    // Variant 3: Wrap try-catch inside a loop, still single catch
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            try {
                throw new java.io.IOException();
            } catch (java.io.IOException e) {
                System.out.println("IOException caught");
                break;
            }
        }
    }
}