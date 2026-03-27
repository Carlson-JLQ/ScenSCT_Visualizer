// Wrapper method calling format with more specifiers than array length should be flagged as mismatched argument count.
package scensct.core.pos;

import java.util.Locale;

public class PosCase2 {
    // Scenario 2: Wrapper method that internally calls String.format
    static String formatWrapper(String fmt, Object... args) {
        return String.format(fmt, args);
    }

    public static void main(String[] args) {
        // Call wrapper with 3 specifiers but only 2 arguments in array
        String result = formatWrapper("%s %d %f", "test", 42); // [REPORTED LINE]
        System.out.println(result);
    }
}