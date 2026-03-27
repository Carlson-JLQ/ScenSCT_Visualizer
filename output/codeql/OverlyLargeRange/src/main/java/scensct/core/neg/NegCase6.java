// A regular expression literal that is defined but not used should not be flagged.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        // Regex literal is dead code (commented out), thus not analyzed.
        // Pattern p = Pattern.compile("[A-Za-z]");
    }
}