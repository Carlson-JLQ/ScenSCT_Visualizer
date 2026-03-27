// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Split string with concatenation, DEL as Unicode escape
        String s = "text" + "\u007F" + "more";
        // Zero-width space as Unicode escape
        String t = "text" + "\u200B" + "more";
        // Numeric literal as hex
        int n = 0x7F;
    }
}