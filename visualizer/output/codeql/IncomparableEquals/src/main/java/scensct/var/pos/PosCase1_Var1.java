// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with different variable names and expressions
        String text = new String("world");
        Integer number = Integer.valueOf(100);
        boolean check = text.equals(number); // [REPORTED LINE]
    }
}