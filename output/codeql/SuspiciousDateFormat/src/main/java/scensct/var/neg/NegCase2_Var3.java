// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        String pattern = getPattern();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
    
    private static String getPattern() {
        return "yyyy-MM-dd";
    }
}