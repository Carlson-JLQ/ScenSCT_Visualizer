// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase3_Var2 {
    // Variant 2: Inter-procedural refactoring - helper method returns literal
    private static String getFormat() {
        return "yyyy-MM-dd";
    }
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(getFormat());
    }
}