// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        final String datePattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(datePattern);
    }
}