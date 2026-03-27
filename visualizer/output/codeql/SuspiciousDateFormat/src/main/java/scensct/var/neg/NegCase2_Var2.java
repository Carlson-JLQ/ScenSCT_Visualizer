// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        String pattern;
        if (args.length > 0) {
            pattern = args[0];
        } else {
            pattern = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}