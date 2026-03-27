// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.var.pos;

public class PosCase2_Var4 {
    private static final int SHIFT_AMOUNT = 64; // Compile-time constant field
    
    public static void main(String[] args) {
        long y = 10L;
        long result = y << SHIFT_AMOUNT; // Shift using static final constant // [REPORTED LINE]
        System.out.println(result);
    }
}