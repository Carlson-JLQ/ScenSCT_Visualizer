// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        int x = 5;
        int result = x << 32; // Shift amount 32 >= 32, truncated modulo 32 // [REPORTED LINE]
        System.out.println(result);
    }
}