// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Introduce a temporary variable for the format string
        String formatPattern = "%s %d";
        String input = "hello";
        String result = String.format(formatPattern, input); // [REPORTED LINE]
        System.out.println(result);
    }
}