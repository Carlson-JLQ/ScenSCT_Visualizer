// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        int x = getX();
        int y = getY();
        try {
            // Comparison inside try block
            if (x < y) {
                System.out.println("x is less than y");
            }
        } catch (Exception e) {
            // Never thrown
        }
    }
    private static int getX() {
        return 5;
    }
    private static int getY() {
        return 10;
    }
}