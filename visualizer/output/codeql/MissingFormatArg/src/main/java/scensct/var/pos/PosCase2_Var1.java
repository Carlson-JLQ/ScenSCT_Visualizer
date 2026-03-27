// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase2_Var1 {
    // Variant 1: Introduce a temporary array and rename method
    static String formatHelper(String pattern, Object... params) {
        // Delegate directly
        return String.format(pattern, params);
    }

    public static void main(String[] args) {
        // Build arguments separately
        Object[] argArray = new Object[] { "example", 100 };
        // Still 3 specifiers, 2 arguments
        String output = formatHelper("%s %d %f", argArray); // [REPORTED LINE]
        System.out.println(output);
    }
}