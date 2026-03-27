// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.var.pos;

import java.text.SimpleDateFormat;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Introduce temporary variable and aliasing
        String base = "%Y-%M";
        String fullPattern = base + "-%d";
        SimpleDateFormat sdf = new SimpleDateFormat(fullPattern);
    }
}