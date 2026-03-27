// Scenario 3: Binary operator with more whitespace around inner operator, excluding same-kind and specific left-child mismatches, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int res = x - y   * z; // [REPORTED LINE]
    }
}