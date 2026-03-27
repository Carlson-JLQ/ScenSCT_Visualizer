// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        String[] parts = {"yyyy", "-MM-dd"};
        String pattern = parts[0] + parts[1];
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}