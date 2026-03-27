// A try statement with at least two catch clauses where the exception type caught by the first clause (masking) is not a strict supertype of the exception type caught by the second clause (masked) should not be flagged as unreachable catch.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Variant 4: Control-Flow Restructuring with Nested Try
    // - Outer try catches one exception, inner try catches the other.
    // - But preserve that both catches are reachable and unrelated.
    // - Use original exception types.
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                throw new java.io.IOException();
            }
            try {
                if (args.length <= 0) {
                    throw new java.sql.SQLException();
                }
            } catch (java.sql.SQLException e) {
                System.out.println("SQLException caught inside");
            }
        } catch (java.io.IOException e) {
            System.out.println("IOException caught outside");
        }
    }
}