// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        int x = 5;
        // Scenario 1: if with braced body (block statement)
        if (x > 0) {
            System.out.println("Positive");
        }
        // else with braced body
        else {
            System.out.println("Non-positive");
        }
        // for loop with braced body
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        // while loop with braced body
        while (x > 0) {
            x--;
        }
    }
}