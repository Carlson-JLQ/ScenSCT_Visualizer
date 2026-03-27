// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.core.neg;

public class NegCase2 {
    public static void main(String[] args) {
        // Empty string literal
        String empty = "";
        // Another empty string literal
        String anotherEmpty = new String("");
        System.out.println(empty + anotherEmpty);
    }
}