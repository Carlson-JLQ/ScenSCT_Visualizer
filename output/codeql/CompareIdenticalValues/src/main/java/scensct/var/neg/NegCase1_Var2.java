// Comparing different integer literals should not be flagged as identical operand comparison.
package scensct.var.neg;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Use different literal representations (hex, decimal)
        int a = 0x5; // hex for 5
        int b = 10;
        // Compare via Integer objects (auto-unboxed)
        Integer objA = a;
        Integer objB = b;
        boolean result = (objA == objB); // Still compares int values after unboxing
        // Use arithmetic expressions that evaluate to distinct values
        boolean result2 = ((a * 1) == (b / 1));
        // Embed comparisons in a try-catch block (no exception thrown)
        try {
            boolean lt = (a < b);
        } catch (Exception e) {
            // ignored
        }
        // Use a switch to select comparison (but always distinct)
        int choice = 1;
        boolean gt = false;
        switch (choice) {
            case 1:
                gt = (b > a);
                break;
            default:
                gt = (a > b);
        }
        // Chain assignments and compare
        int c = a, d = b;
        boolean le = (c <= d);
        boolean ge = (d >= c);
        boolean ne = (c != d);
    }
}