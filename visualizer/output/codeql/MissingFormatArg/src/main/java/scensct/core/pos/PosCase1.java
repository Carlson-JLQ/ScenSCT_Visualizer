// Direct format call with more specifiers than arguments should be flagged as mismatched argument count.
package scensct.core.pos;

import java.util.Locale;

public class PosCase1 {
    public static void main(String[] args) {
        // Scenario 1: Direct call to String.format with 2 specifiers but only 1 argument
        String result = String.format("%s %d", "hello"); // [REPORTED LINE]
        System.out.println(result);
    }
}