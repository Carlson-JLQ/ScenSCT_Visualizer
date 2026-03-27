// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.core.neg;

import java.text.SimpleDateFormat;

public class NegCase2 {
    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd"; // First argument is a variable, not a literal
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}