// Multiplication implicitly converted to same-sized or non-integral type should not be flagged as overflow before widening to larger integral type.
package scensct.var.neg;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        int m = 100;
        int n = 200;
        
        // Use helper method for float conversion
        float floatResult = computeFloat(m, n);
        long longResult = m * n; // Widening kept inline
        
        System.out.println(floatResult);
    }
    
    private static float computeFloat(int p, int q) {
        return p * q; // Implicit conversion to float in return
    }
}