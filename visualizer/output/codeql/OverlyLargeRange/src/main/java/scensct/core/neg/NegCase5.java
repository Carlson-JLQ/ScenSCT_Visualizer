// A regular expression that is not defined as a literal should not be flagged.
package scensct.core.neg;

import java.util.regex.Pattern;

public class NegCase5 {
    public static void main(String[] args) {
        // Regex is constructed via string concatenation, not a literal analyzed by checker.
        String regex = "[A-Z]";
        Pattern p = Pattern.compile(regex);
    }
}