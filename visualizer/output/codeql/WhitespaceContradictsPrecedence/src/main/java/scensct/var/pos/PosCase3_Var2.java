// Scenario 3: Binary operator with more whitespace around inner operator, excluding same-kind and specific left-child mismatches, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase3_Var2 {
    public static void main(String[] args) {
        int val1 = 1;
        int val2 = 2;
        int val3 = 3;
        int tmp = val1 - val2   * val3; // [REPORTED LINE]
        System.out.println(tmp);
    }
}