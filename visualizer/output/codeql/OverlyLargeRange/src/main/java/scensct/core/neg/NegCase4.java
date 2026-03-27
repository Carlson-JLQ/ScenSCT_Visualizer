// A regular expression containing a character range that is not overly wide should not be flagged.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase4 {
    public static void main(String[] args) {
        // Range 'a' to 'f' spans fewer than 10 characters.
        Pattern p = Pattern.compile("[a-f]");
    }
}