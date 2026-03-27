// SimpleDateFormat constructor with literal containing both %Y and %M should be flagged as suspicious date format pattern.
package scensct.core.pos;

import java.text.SimpleDateFormat;

public class PosCase1 {
    public static void main(String[] args) {
        // Direct literal argument containing both %Y and %M
        SimpleDateFormat sdf = new SimpleDateFormat("%Y-%M-%d"); // [REPORTED LINE]
    }
}