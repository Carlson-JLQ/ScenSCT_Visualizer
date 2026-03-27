// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Empty via concatenation of two substrings of an empty string
        String empty = "".substring(0, 0) + "".substring(0, 0);
        // Another empty via String constructor with concatenated empty
        String anotherEmpty = new String(empty);
        System.out.println(empty + anotherEmpty);
    }
}