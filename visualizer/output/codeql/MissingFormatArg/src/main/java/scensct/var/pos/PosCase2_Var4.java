// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase2_Var4 {
    // Variant 4: Extract argument construction into a helper method
    static String formatWrapper(String fmt, Object... args) {
        return String.format(fmt, args);
    }

    private static Object[] buildArgs(String s, int i) {
        return new Object[] { s, i };
    }

    public static void main(String[] args) {
        // Get arguments from helper
        Object[] supplied = buildArgs("test", 42);
        // Call wrapper with array spread
        String result = formatWrapper("%s %d %f", supplied);
        System.out.println(result);
    }
}