// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase4_Var3 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int result = values[0] ^ values[1]   & values[2]; // Use array accesses // [REPORTED LINE]
    }
    
    // Helper to demonstrate inter-procedural possibility but not used here
    static int compute(int p, int q, int r) {
        return p ^ q   & r; // [REPORTED LINE]
    }
}