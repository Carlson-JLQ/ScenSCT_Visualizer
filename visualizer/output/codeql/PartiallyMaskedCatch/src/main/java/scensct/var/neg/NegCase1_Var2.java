// A try statement with at least two catch clauses where the exception type caught by the first clause (masking) is not a strict supertype of the exception type caught by the second clause (masked) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Inter-Procedural Refactoring
    // - Extract exception throwing into a helper method.
    // - Extract catching logic into another helper.
    // - Maintain unrelated exception types and reachability.
    private static void processInput(String[] inputs) throws java.io.IOException, java.sql.SQLException {
        if (inputs.length > 0) {
            throw new java.io.IOException();
        } else {
            throw new java.sql.SQLException();
        }
    }
    
    private static void handleException(java.lang.Exception e) {
        if (e instanceof java.io.IOException) {
            System.out.println("IOException handled");
        } else if (e instanceof java.sql.SQLException) {
            System.out.println("SQLException handled");
        }
    }
    
    public static void main(String[] args) {
        try {
            processInput(args);
        } catch (java.io.IOException e) {
            handleException(e);
        } catch (java.sql.SQLException e) {
            handleException(e);
        }
    }
}