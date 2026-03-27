// Comparison with structurally identical binary expressions should be flagged as identical operands.
package scensct.core.pos;

public class PosCase3 {
    public static void main(String[] args) {
        int x = 5;
        int a = 2, b = 3;
        boolean b1 = (x + 1) > (x + 1);      // Scenario 3: identical addition expressions // [REPORTED LINE]
        boolean b2 = (a * b) == (a * b);     // Scenario 3: identical multiplication expressions // [REPORTED LINE]
        boolean b3 = (x - 2) <= (x - 2);     // Scenario 3: identical subtraction expressions // [REPORTED LINE]
    }
}