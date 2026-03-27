// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Extract the format call into a helper method
        String result = formatWithMismatch();
        System.out.println(result);
    }

    private static String formatWithMismatch() {
        return String.format("%s %d", "hello"); // [REPORTED LINE]
    }
}