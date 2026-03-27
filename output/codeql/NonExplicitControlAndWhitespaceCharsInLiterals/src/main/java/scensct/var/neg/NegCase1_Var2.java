// Printable ASCII and normal whitespace in string/numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Helper method to construct string with normal whitespace
    private static String buildWhitespace() {
        return " \t\n\r\f";
    }
    
    // Helper method for numeric literal via different representation
    private static int getAnswer() {
        return 042 - 10 + 10; // octal 42 is decimal 34, but recalculated to 42
    }
    
    public static void main(String[] args) {
        // Variant 2: Inter-procedural extraction and arithmetic equivalence
        String text = "Hello, World! 123";
        String whitespace = buildWhitespace();
        int number = getAnswer(); // still 42
        int hex = 0x2A;
        int binary = 0b101010;
        String escaped = "Tab:\tNewline:\nReturn:\rFormfeed:\f";
        System.out.println(text + whitespace + number + hex + binary + escaped);
    }
}