// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        long asLong = a * b; // Widening to long
        float asFloat = a * b; // Conversion to float
        System.out.println(asFloat);
    }
}