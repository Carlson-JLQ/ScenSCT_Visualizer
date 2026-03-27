// A java.text.SimpleDateFormat constructor call with a string literal first argument whose value contains "%Y" but does not contain "%M" should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.SimpleDateFormat;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Complex expression with string operations that preserve the invariant
        StringBuilder sb = new StringBuilder();
        sb.append('%').append('Y').append('-').append('m').append('-').append('d');
        SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());
    }
}