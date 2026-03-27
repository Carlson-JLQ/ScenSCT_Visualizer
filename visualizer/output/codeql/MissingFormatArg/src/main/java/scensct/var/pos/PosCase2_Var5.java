// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase2_Var5 {
    // Variant 5: Add try-catch block but preserve the call
    static String formatWrapper(String fmt, Object... args) {
        try {
            return String.format(fmt, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Mismatch remains
        String result = formatWrapper("%s %d %f", "item", 999); // [REPORTED LINE]
        System.out.println(result);
    }
}