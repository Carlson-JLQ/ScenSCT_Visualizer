// Left shift with constant shift amount less than bit width should not be flagged as shift amount >= bit width.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Complex constant expressions and nested control flow
    private static final int SHIFT_A = 10 - 5;  // evaluates to 5
    private static final long SHIFT_B = 50L - 10L;  // evaluates to 40
    private static final int SHIFT_C = 1 + 2;  // evaluates to 3
    
    public static void main(String[] args) {
        if (true) {  // always taken
            int x = 1 << SHIFT_A;  // 5 < 32
            System.out.println(x);
        }
        
        long y = 1L;
        for (int i = 0; i < 1; i++) {
            y = y << SHIFT_B;  // 40 < 64
        }
        System.out.println(y);
        
        byte z = 1;
        int w = z << SHIFT_C;  // 3 < 32
        System.out.println(w);
    }
}