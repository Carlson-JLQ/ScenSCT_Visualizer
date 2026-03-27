// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.var.pos;

import java.text.SimpleDateFormat;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with conditional that always passes
        String pattern;
        if (args.length >= 0) { // always true
            pattern = "%Y-%M-%d";
        } else {
            pattern = "unused";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}