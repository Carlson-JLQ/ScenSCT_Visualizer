// Control structure body is a block statement should not be flagged as misleading indentation.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int x = 5;
        // if-else with braces, but using a switch-like pattern via if-else chain
        if (x > 0) {
            handlePositive();
        } else {
            handleNonPositive();
        }
        // for loop with braces, using post-increment inside body
        for (int i = 0; i < 3; ) {
            System.out.println(i);
            i++;
        }
        // while loop with braces, condition negated and loop inverted
        while (true) {
            if (x <= 0) break;
            x--;
        }
    }

    private static void handlePositive() {
        System.out.println("Positive");
    }

    private static void handleNonPositive() {
        System.out.println("Non-positive");
    }
}