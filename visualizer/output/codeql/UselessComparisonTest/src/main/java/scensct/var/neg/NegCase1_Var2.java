// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        int val1 = getX();
        int val2 = getY();
        // Loop with single iteration to obscure direct flow
        while (true) {
            if (val1 < val2) {
                System.out.println("x is less than y");
            }
            break;
        }
    }
    private static int getX() {
        return 5;
    }
    private static int getY() {
        return 10;
    }
}