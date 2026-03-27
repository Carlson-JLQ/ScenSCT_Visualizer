// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split and concatenate literal
        String format = "yyyy" + "-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
    }
}