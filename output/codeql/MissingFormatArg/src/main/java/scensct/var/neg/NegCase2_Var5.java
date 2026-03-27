// A method call where the called method is not a recognized format method should not be flagged.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Complex argument with percent sign but not a format specifier
        String text = "100% pure";
        System.out.println(text); // Contains '%' but not a format specifier
    }
}