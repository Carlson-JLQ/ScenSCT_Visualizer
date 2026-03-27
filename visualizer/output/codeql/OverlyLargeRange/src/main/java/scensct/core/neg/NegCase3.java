// A regular expression containing a character range that spans 10+ characters but does not cross key gaps or have non-alphanumeric ASCII bounds should not be flagged.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase3 {
    public static void main(String[] args) {
        // Range '0' to '9' spans 10 characters, does not cross Z-a or 9-A gaps, both bounds are alphanumeric ASCII.
        Pattern p = Pattern.compile("[0-9]");
    }
}