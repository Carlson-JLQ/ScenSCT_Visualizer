// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value contains "%Y" but does not contain "%M" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase4_Var2 {
    // Variant 2: Inter-procedural refactoring - extract format to a static method
    private static String getDateFormat() {
        return "%Y-%m-%d";
    }
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(getDateFormat());
    }
}