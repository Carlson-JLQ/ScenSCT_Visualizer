// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Split the format string across concatenation, but still mismatch
        String spec1 = "%s";
        String spec2 = " %d";
        String result = String.format(spec1 + spec2, "hello"); // [REPORTED LINE]
        System.out.println(result);
    }
}