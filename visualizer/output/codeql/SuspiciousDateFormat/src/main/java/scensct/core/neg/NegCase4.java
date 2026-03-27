// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value contains "%Y" but does not contain "%M" should not be flagged as suspicious date format pattern.
package scensct.core.neg;

import java.text.SimpleDateFormat;

public class NegCase4 {
    public static void main(String[] args) {
        // Pattern literal contains "%Y" but not "%M"
        SimpleDateFormat sdf = new SimpleDateFormat("%Y-%m-%d");
    }
}