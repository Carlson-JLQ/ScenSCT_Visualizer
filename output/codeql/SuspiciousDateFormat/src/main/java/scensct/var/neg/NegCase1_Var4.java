// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.DateFormat;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use conditional to obscure the constructor type (but still DateFormat)
        DateFormat df;
        if (args.length > 0) {
            df = new java.text.SimpleDateFormat("yyyy-MM-dd");
        } else {
            df = DateFormat.getDateInstance();
        }
        // The SimpleDateFormat constructor is reachable but not guaranteed
    }
}