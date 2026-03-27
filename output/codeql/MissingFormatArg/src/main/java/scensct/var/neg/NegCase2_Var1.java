// A method call where the called method is not a recognized format method should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - string concatenation
        String message = "Hello" + " World";
        System.out.println(message);
    }
}