// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        try {
            // Try block that can throw Exception and IOException
            if (args.length > 0) {
                throw new Exception();
            } else {
                throw new java.io.IOException();
            }
        } catch (java.sql.SQLException e) {
            // First catch: SQLException, which is not a subtype of Exception (masked type not caught here), so not masked
            System.out.println("SQLException caught");
        } catch (Exception e) {
            // Second catch: Exception (masking type)
            System.out.println("Exception caught");
        }
    }
}