// A regular expression containing a character range that is overly wide, overlaps with another higher-ranked range, overlaps with a shorthand escape character class, and is not an empty range should be flagged as suspicious.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        // Overly wide range [0-9] overlaps with higher-ranked [5-7] and shorthand \d in same class, not empty
        String regex = "[0-9[5-7]\\d]";
        java.util.regex.Pattern.compile(regex);
    }
}