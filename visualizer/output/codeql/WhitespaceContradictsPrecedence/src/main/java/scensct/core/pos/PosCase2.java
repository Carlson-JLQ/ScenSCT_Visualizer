// Scenario 2: Binary operator with more whitespace around inner operator, not in precedence-compatible pairs, should be flagged as misleading spacing.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = a & b   | c; // Inner '|' has lower precedence than '&' but more whitespace
    }
}