// A regular expression containing a character range that is overly wide but is the only range in its character class should not be flagged as overlapping.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase1 {
    public static void main(String[] args) {
        // Single range [A-Za-z0-9] is wide and crosses boundaries, but no other range to compare for overlap.
        Pattern p = Pattern.compile("[A-Za-z0-9]");
    }
}