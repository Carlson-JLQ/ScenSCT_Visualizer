// Using arithmetic addition operator should not be flagged as identical operand comparison.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        int x = 3;
        int y = 7;
        // Scenario 2: Non-comparison operator (+) used, not a comparison.
        int sum = x + y;
        // Additional non-comparison operators to demonstrate.
        int diff = x - y;
        int prod = x * y;
        int quot = x / y;
        int and = x & y;
        int or = x | y;
        int xor = x ^ y;
        // Assignment operator, also non-comparison.
        x = y;
    }
}