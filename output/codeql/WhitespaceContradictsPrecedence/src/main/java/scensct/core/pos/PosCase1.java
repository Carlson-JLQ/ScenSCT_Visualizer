// Scenario 1: Binary operator with more whitespace around inner higher-precedence operator should be flagged as misleading spacing.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int result = a + b   * c; // Inner '*' has higher precedence but more whitespace than outer '+' // [REPORTED LINE]
    }
}