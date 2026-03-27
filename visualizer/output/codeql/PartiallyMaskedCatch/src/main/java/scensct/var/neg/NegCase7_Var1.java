// A try statement where the catch clause at index first catches exception type masking, but the catch clause at index second does not catch exception type masked should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        try {
            // Variant 1: Lexical refactoring - use a switch-like if-else chain
            boolean flag = args.length > 0;
            if (flag) {
                throw new Exception("Argument present");
            }
            throw new java.io.IOException("No arguments");
        } catch (java.sql.SQLException e) {
            // Still first catch: SQLException
            System.err.println("SQLException: " + e.getMessage());
        } catch (Exception e) {
            // Still second catch: Exception
            System.err.println("General Exception: " + e.getMessage());
        }
    }
}