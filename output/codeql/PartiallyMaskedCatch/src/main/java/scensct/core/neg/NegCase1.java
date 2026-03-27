// A try statement with at least two catch clauses where the exception type caught by the first clause (masking) is not a strict supertype of the exception type caught by the second clause (masked) should not be flagged as unreachable catch.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        try {
            // Try block that can throw both IOException and SQLException
            if (args.length > 0) {
                throw new java.io.IOException();
            } else {
                throw new java.sql.SQLException();
            }
        } catch (java.io.IOException e) {
            // First catch: IOException
            System.out.println("IOException caught");
        } catch (java.sql.SQLException e) {
            // Second catch: SQLException, not a subtype of IOException, so not masked
            System.out.println("SQLException caught");
        }
    }
}