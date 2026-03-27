// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Empty via ternary operator always choosing empty
        String empty = args.length > 1000 ? "not empty" : "";
        // Another empty via switch expression that yields empty
        String anotherEmpty = switch (args.length) {
            default -> "";
        };
        System.out.println(empty + anotherEmpty);
    }
}