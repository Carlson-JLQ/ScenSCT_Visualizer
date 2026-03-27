// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control flow with constant conditional
        final boolean useStandard = true;
        String pattern;
        if (useStandard) {
            pattern = "yyyy-MM-dd";
        } else {
            pattern = "dd/MM/yyyy"; // Also safe, but unreachable
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}