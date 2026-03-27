// String literal containing DEL (U+007F) should be flagged as containing a non-explicit control character.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Use StringBuilder to construct string with DEL
        StringBuilder sb = new StringBuilder();
        sb.append("text");
        sb.append('\u007F'); // DEL as char literal
        sb.append("more");
        String s = sb.toString();
        
        // Zero-width space in a text block (Java 15+)
        String t = """ // [REPORTED LINE]
                  text​more
                  """.trim();
        
        // Numeric literal in an array initializer
        int[] arr = { 0177 };
        int n = arr[0];
    }
}