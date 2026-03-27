// A regular expression containing a character range that is overly wide and overlaps with another higher-ranked range in the same character class, but does not overlap with any shorthand escape character class (like \w, \d, \s) in the same character class should be flagged as suspicious.
package scensct.ref.pos;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        // Overly wide range [a-z] overlaps with higher-ranked [m-p] in same class, no shorthand overlap
        String regex = "[a-z[m-p]]";
        System.out.println(regex);
    }
}