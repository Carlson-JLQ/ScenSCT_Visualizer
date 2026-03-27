// Scenario 4: Binary operator with more whitespace around inner operator, satisfying both exclusion sets, should be flagged as misleading spacing.
package scensct.core.pos;

public class PosCase4 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = a ^ b   & c; // Inner '&' has higher precedence than '^' but more whitespace, satisfying all exclusions // [REPORTED LINE]
    }
}