// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        long y = 10L;
        long result = y << 64; // Shift amount 64 >= 64, truncated modulo 64 // [REPORTED LINE]
        System.out.println(result);
    }
}