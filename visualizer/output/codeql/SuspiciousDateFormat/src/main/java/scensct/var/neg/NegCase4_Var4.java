// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value contains "%Y" but does not contain "%M" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase4_Var4 {
    // Variant 4: Idiomatic variation - use a final constant field
    private static final String DATE_PATTERN = "%Y-%m-%d";
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
    }
}