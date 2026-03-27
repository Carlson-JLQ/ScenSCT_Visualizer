// Scenario 1: Binary operator with more whitespace around inner higher-precedence operator should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int res = x + y    * z; // Increased whitespace around '*', still misleading
    }
}