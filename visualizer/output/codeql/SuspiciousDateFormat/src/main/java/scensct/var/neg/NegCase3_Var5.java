// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase3_Var5 {
    // Variant 5: Intra-procedural refactoring with try-catch (unrelated)
    public static void main(String[] args) {
        try {
            String format = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
        } catch (IllegalArgumentException e) {
            // Handle unrelated exception (pattern is valid, so never thrown)
            System.err.println("Invalid pattern");
        }
    }
}