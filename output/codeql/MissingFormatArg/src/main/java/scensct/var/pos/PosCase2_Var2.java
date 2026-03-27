// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase2_Var2 {
    // Variant 2: Restructure with a conditional path that always takes the mismatched branch
    static String formatWrapper(String fmt, Object... args) {
        return String.format(fmt, args);
    }

    public static void main(String[] args) {
        boolean flag = true;
        String result = null;
        if (flag) {
            // This branch always executes
            result = formatWrapper("%s %d %f", "data", 7); // [REPORTED LINE]
        } else {
            result = "unused";
        }
        System.out.println(result);
    }
}