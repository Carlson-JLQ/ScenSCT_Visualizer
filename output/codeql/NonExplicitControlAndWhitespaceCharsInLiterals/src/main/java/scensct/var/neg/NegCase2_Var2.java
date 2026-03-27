// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Empty string from a constant
        final String EMPTY_CONST = "";
        String empty = EMPTY_CONST;
        // Another empty via StringBuilder
        String anotherEmpty = new StringBuilder().toString();
        System.out.println(empty + anotherEmpty);
    }
}