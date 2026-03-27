// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value contains "%Y" but does not contain "%M" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split string literal into concatenated parts
        String format = "%Y" + "-%m-%d";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
    }
}