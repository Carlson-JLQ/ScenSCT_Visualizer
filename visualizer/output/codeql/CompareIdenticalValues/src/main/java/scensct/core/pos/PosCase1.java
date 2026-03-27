// Comparison with identical string literals should be flagged as identical operands.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        boolean b1 = 5 == 5;          // Scenario 1: identical integer literals // [REPORTED LINE]
        boolean b2 = "abc" != "abc";  // Scenario 1: identical string literals // [REPORTED LINE]
        boolean b3 = 3.14 <= 3.14;    // Scenario 1: identical floating-point literals // [REPORTED LINE]
    }
}