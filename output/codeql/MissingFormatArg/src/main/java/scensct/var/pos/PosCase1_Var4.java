// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.var.pos;

import java.util.Locale;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Add dead code and reorder, but keep the mismatched call
        if (args.length > 1000) {
            System.out.println("Unreachable");
        }
        String result = String.format("%s %d", "hello"); // [REPORTED LINE]
        System.out.println(result);
    }
}