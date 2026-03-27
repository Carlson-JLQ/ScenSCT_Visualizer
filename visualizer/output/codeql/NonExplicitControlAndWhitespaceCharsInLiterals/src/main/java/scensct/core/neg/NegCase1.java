// Printable ASCII and normal whitespace in string/numeric literals should not be flagged as containing non-explicit control characters.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Printable ASCII string literal
        String text = "Hello, World! 123";
        // String with normal whitespace: space, tab, newline, carriage return, form feed
        String whitespace = " \t\n\r\f";
        // Numeric literal (decimal)
        int number = 42;
        // Numeric literal (hex)
        int hex = 0x2A;
        // Numeric literal (binary)
        int binary = 0b101010;
        // String with escaped normal whitespace
        String escaped = "Tab:\tNewline:\nReturn:\rFormfeed:\f";
        System.out.println(text + whitespace + number + hex + binary + escaped);
    }
}