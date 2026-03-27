// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.var.neg;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        int x = 100;
        int y = 200;
        float f;
        
        if (x > 0) {
            f = x * y; // Conversion in branch
        } else {
            f = 0.0f;
        }
        
        long l = x * y; // Widening after branch
        System.out.println(f);
    }
}