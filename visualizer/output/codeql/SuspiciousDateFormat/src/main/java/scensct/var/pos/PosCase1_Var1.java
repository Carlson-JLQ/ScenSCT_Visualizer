// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.var.pos;

import java.text.SimpleDateFormat;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split pattern into concatenated literals
        String pattern = "%Y" + "-%M-" + "d";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    }
}