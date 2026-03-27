// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use explicit Locale, but still mismatch
        Locale locale = Locale.US;
        String result = String.format(locale, "%s %d", "hello"); // [REPORTED LINE]
        System.out.println(result);
    }
}