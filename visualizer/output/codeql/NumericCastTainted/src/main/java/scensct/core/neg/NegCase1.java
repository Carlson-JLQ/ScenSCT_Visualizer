// Implicit narrowing conversion via assignment should not be flagged as numeric narrowing cast.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Implicit narrowing conversion (int literal to byte) without explicit cast.
        byte b = 100; // No explicit cast, should not trigger the checker.
        System.out.println(b);
    }
}