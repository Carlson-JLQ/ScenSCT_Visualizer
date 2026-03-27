// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.ref.neg;

public class NegCase1_FP1 {
    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        // Scenario: < is not an equality test, no guard, not constant (x and y are variables)
        if (x < y) { // [REPORTED LINE]
            System.out.println("x is less than y");
        }
    }
}