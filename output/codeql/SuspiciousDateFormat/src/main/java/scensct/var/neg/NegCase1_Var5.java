// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.DateFormat;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use a try-catch block, but still assign to DateFormat
        DateFormat df = null;
        try {
            df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        } catch (Exception e) {
            df = DateFormat.getDateInstance();
        }
        // The constructor is inside try, but type is DateFormat
    }
}