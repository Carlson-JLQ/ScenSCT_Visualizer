// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Extract comparison into a helper method
    private static boolean alwaysTrueComparison(int val) {
        int incremented = val + 1;
        return incremented > val; // Always true
    }
    
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            boolean b = alwaysTrueComparison(i);
            System.out.println(b);
            i++;
        }
    }
}