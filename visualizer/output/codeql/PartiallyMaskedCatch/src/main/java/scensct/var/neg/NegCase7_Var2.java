// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase7_Var2 {
    // Variant 2: Intra-procedural - nest try-catch inside a loop
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) { // Loop runs once, but changes control flow
            try {
                // Throw based on args, but using a temporary variable
                java.io.IOException ioEx = new java.io.IOException();
                Exception genEx = new Exception();
                throw args.length > 0 ? genEx : ioEx;
            } catch (java.sql.SQLException e) {
                System.out.println("Caught SQLException");
                break;
            } catch (Exception e) {
                System.out.println("Caught Exception");
                break;
            }
        }
    }
}