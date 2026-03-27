// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.var.pos;

public class PosCase2_Var3 {
    private static long shiftLeft(long x, int bits) {
        return x << bits; // Shift moved to helper method
    }
    
    public static void main(String[] args) {
        long y = 10L;
        long result = shiftLeft(y, 64); // Constant 64 passed to helper
        System.out.println(result);
    }
}