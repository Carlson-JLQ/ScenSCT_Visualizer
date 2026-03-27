// A regular expression containing a character range that spans 10+ characters but matches a known false-positive pattern should not be flagged.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase2 {
    public static void main(String[] args) {
        // Range '@' to '_' is a known false-positive pattern (spans 10+ characters).
        Pattern p = Pattern.compile("[@-_]");
    }
}