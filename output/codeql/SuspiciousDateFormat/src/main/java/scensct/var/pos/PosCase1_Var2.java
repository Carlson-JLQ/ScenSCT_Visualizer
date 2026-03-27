// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.var.pos;

import java.text.SimpleDateFormat;

public class PosCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extract pattern to a helper method
    private static String getPattern() {
        return "%Y-%M-%d";
    }
    
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(getPattern());
    }
}