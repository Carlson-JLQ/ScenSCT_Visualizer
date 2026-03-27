// A recognized format method call with specifier count <= argument count should not be flagged.
package scensct.var.neg;

public class NegCase9_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical - rename variable and use a temporary for the format string
        String pattern = "Hello %s";
        String greeting = "world";
        String output = String.format(pattern, greeting);
    }
}