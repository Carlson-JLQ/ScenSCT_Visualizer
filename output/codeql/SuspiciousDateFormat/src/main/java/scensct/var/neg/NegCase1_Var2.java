// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.DateFormat;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Assign via a temporary variable and cast
        Object temp = new java.text.SimpleDateFormat("yyyy-MM-dd");
        DateFormat df = (DateFormat) temp;
        // The constructor call is still for SimpleDateFormat, but assigned to DateFormat
        // This tests if checker tracks static type vs. runtime type
    }
}