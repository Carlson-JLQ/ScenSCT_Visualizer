// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase4_Var2 {
    public static void main(String[] args) {
        int a = 1, b = 2, c = 3;
        int temp = b   & c; // Extract inner operation to temporary
        int result = a ^ temp; // Outer operation with temporary
        // The misleading spacing is now between b and & in the temporary assignment
    }
}