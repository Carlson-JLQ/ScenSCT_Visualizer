// A java.text.SimpleDateFormat constructor call where the first argument is not a string literal should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("yyyy");
        sb.append("-MM-dd");
        String pattern = sb.toString();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}