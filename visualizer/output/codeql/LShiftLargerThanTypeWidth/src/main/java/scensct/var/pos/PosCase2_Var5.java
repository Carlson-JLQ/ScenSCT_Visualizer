// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.var.pos;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        long y = 10L;
        int shift = 63;
        shift++; // Becomes 64 at runtime, but NOT a compile-time constant
        long result = y << shift; // This should NOT be reported by the checker
        System.out.println(result);
    }
}