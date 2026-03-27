// Scenario 1: Binary operator with more whitespace around inner higher-precedence operator should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int temp = b   * c; // Inner operation extracted to temporary, but spacing preserved
        int result = a + temp;
    }
}