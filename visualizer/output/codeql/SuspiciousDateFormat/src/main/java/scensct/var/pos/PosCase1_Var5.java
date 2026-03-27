// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.var.pos;

import java.text.SimpleDateFormat;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try-catch block that doesn't affect reachability
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("%Y-%M-%d"); // [REPORTED LINE]
        } catch (IllegalArgumentException e) {
            // This won't happen with valid pattern
            throw new RuntimeException(e);
        }
    }
}