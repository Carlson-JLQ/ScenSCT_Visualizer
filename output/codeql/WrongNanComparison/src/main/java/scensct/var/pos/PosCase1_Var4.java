// Equality comparison with Float.NaN should be flagged as always false for == and always true for !=.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Restructure control flow: comparison inside a loop that always executes once.
        boolean result1 = false;
        boolean result2 = false;
        for (int i = 0; i < 1; i++) {
            result1 = (Float.NaN == 1.0f); // Should still report: == with Float.NaN inside loop // [REPORTED LINE]
            result2 = (Double.NaN != 2.0); // Should still report: != with Double.NaN inside loop // [REPORTED LINE]
        }
        System.out.println(result1 + " " + result2);
    }
}