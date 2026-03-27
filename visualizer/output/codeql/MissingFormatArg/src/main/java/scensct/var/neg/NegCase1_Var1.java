// A Java expression that is not a method call should not be flagged as a format specifier mismatch.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: String concatenation splits the literal
        String part1 = "Hello ";
        String part2 = "%s";
        String s = part1 + part2; // Still just a string, no format call
        System.out.println(s.length()); // Different unrelated method call
    }
}