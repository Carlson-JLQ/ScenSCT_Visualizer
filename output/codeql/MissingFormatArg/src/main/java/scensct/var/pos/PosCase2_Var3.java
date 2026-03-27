// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase2_Var3 {
    // Variant 3: Use Locale version and inline the wrapper logic
    private static String formatWithLocale(Locale loc, String fmt, Object... args) {
        return String.format(loc, fmt, args);
    }

    public static void main(String[] args) {
        // Pass Locale, still 3 specifiers vs 2 args
        String out = formatWithLocale(Locale.US, "%s %d %f", "value", 255); // [REPORTED LINE]
        System.out.println(out);
    }
}