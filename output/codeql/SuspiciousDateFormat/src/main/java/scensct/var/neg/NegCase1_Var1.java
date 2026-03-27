// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.DateFormat;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use a factory method that returns DateFormat, not SimpleDateFormat
        DateFormat df = DateFormat.getDateInstance();
        // The pattern is not passed, so no risk of detection
    }
}