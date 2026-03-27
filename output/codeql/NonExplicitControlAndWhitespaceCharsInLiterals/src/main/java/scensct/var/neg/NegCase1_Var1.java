// Printable ASCII and normal whitespace in string/numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with equivalent expressions and reordering
        int hex = 0x2A; // 42 in hex
        int binary = 0b00101010; // padded binary literal
        int number = hex; // alias via assignment
        String text = "Hello, World! " + 123; // split numeric part
        String whitespace = "\t\n\r\f "; // reorder whitespace characters
        String escaped = "Tab:" + '\t' + "Newline:" + '\n' + "Return:" + '\r' + "Formfeed:" + '\f';
        System.out.println(whitespace + text + number + binary + escaped);
    }
}