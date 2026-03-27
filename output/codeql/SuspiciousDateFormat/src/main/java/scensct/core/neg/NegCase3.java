// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value does not contain "%Y" should not be flagged as suspicious date format pattern.
package scensct.core.neg;

import java.text.SimpleDateFormat;

public class NegCase3 {
    public static void main(String[] args) {
        // Pattern literal contains no "%Y"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    }
}