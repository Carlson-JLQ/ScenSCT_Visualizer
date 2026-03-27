// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        int i = 100;
        int j = 200;
        
        // Using Float.valueOf which expects a float, causing implicit conversion
        Float boxed = Float.valueOf(i * j);
        long direct = i * j; // Widening
        
        System.out.println(boxed);
    }
}