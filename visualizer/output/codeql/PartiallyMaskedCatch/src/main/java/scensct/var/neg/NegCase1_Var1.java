// A try statement with at least two catch clauses where the exception type caught by the first clause (masking) is not a strict supertype of the exception type caught by the second clause (masked) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical & Control-Flow Refactoring
        // - Rename variables and add a temporary variable for condition.
        // - Restructure try block with a loop that breaks after throwing.
        // - Preserve unrelated exception types.
        boolean flag = args.length > 0;
        int attempt = 0;
        while (attempt < 1) {
            try {
                if (flag) {
                    throw new java.io.IOException("File not found");
                } else {
                    throw new java.sql.SQLException("Database error");
                }
            } catch (java.io.IOException ex) {
                System.err.println("Caught IO: " + ex.getMessage());
            } catch (java.sql.SQLException ex) {
                System.out.println("Caught SQL: " + ex.getMessage());
            }
            attempt++;
        }
    }
}