// Scenario 3: Binary operator with more whitespace around inner operator, excluding same-kind and specific left-child mismatches, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = (a) - (b)   * (c); // [REPORTED LINE]
    }
}