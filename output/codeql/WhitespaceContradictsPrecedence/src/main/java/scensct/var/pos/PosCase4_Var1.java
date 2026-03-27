// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.var.pos;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 30;
        int computed = x ^ y   & z; // Same pattern with renamed variables // [REPORTED LINE]
        System.out.println(computed);
    }
}