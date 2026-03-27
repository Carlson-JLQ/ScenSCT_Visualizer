// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int a = getX();
        int b = getY();
        // Temporaries and reordered operands
        int diff = b - a;
        boolean condition = a < b;
        if (condition) {
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