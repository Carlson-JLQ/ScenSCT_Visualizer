// Empty string literal should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Empty via loop that never appends
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 0; i++) {
            sb.append("x");
        }
        String empty = sb.toString();
        // Another empty via String.valueOf on empty char array
        char[] chars = new char[0];
        String anotherEmpty = String.valueOf(chars);
        System.out.println(empty + anotherEmpty);
    }
}