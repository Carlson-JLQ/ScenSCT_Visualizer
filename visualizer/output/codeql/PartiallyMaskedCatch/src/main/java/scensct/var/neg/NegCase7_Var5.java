// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase7_Var5 {
    // Variant 5: Complex control flow with try-catch-finally
    public static void main(String[] args) {
        try {
            try {
                if (args.length > 0) {
                    throw new Exception();
                }
                throw new java.io.IOException();
            } finally {
                // Cleanup that doesn't affect catch reachability
                System.out.println("Inner finally");
            }
        } catch (java.sql.SQLException e) {
            System.out.println("SQLException caught");
        } catch (Exception e) {
            System.out.println("Exception caught");
        }
    }
}