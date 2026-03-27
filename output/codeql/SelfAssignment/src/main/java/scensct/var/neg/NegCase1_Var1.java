// Assignment with source as literal should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        int x = 5;
        // Variant 1: Lexical refactoring - rename variable and use a different literal expression
        int value = 5;
        value = 0xA; // Hexadecimal literal, still a constant
    }
}