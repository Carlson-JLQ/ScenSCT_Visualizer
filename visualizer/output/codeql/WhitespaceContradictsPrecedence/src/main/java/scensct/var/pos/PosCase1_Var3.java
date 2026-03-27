// Scenario 1: Binary operator with more whitespace around inner higher-precedence operator should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result;
        if (args.length == 0) {
            result = a + b   * c; // Misleading spacing inside conditional branch // [REPORTED LINE]
        } else {
            result = 0;
        }
    }
}