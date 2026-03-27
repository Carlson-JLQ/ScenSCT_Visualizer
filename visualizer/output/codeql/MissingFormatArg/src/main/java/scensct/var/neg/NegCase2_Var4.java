// A method call where the called method is not a recognized format method should not be flagged.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - using print instead of println
        System.out.print("Hello\n"); // Equivalent to println("Hello")
    }
}