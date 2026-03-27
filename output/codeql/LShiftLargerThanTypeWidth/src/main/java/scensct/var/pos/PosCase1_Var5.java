// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        int x = 5;
        int result = x << (16 * 2); // compile-time constant 32 // [REPORTED LINE]
        System.out.println(result);
    }
}