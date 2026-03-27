// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int x = getX(); // Non-constant initialization
        int y = getY(); // Non-constant initialization
        // Scenario: < is not an equality test, no guard, not constant (x and y are variables)
        if (x < y) {
            System.out.println("x is less than y");
        }
    }
    private static int getX() {
        return 5;
    }
    private static int getY() {
        return 10;
    }
}