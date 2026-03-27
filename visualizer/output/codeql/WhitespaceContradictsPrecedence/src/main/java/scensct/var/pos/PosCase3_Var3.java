// Scenario 3: Binary operator with more whitespace around inner operator, excluding same-kind and specific left-child mismatches, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase3_Var3 {
    public static void main(String[] args) {
        compute(1, 2, 3);
    }
    
    private static void compute(int p, int q, int r) {
        int out = p - q   * r; // [REPORTED LINE]
    }
}