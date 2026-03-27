// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        long base = 10L;
        int shift = 64; // Constant variable
        long shifted = base << shift; // Shift amount 64 >= 64, truncated modulo 64
        System.out.println(shifted);
    }
}