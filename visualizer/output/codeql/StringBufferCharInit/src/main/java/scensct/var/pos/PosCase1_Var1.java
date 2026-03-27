// Passing a char literal to StringBuffer constructor should be flagged as using capacity instead of character.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use a char variable instead of literal
        char initialChar = 'a';
        StringBuffer buffer = new StringBuffer(initialChar); // [REPORTED LINE]
    }
}