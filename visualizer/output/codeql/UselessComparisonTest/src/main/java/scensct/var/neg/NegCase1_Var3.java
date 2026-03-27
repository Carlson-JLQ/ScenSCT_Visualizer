// Binary expression that is not an equality test, not a useless equality test, and not a constant condition should not be flagged as always true/false.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        int x = getX();
        int y = getY();
        if (isLess(x, y)) {
            System.out.println("x is less than y");
        }
    }
    private static int getX() {
        return 5;
    }
    private static int getY() {
        return 10;
    }
    private static boolean isLess(int a, int b) {
        return a < b;
    }
}