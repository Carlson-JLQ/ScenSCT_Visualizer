// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase3_Var4 {
    // Variant 4: Aliasing via final variable
    public static void main(String[] args) {
        final String FMT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(FMT);
    }
}