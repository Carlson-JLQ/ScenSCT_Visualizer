// Left-shift with long left operand and constant shift >= 64 should be flagged as shift amount truncated modulo 64.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        long value = 10L;
        long result;
        if (System.currentTimeMillis() > 0) { // Always true, but non-constant condition
            result = value << (32 + 32); // Constant expression 64 >= 64 // [REPORTED LINE]
        } else {
            result = 0L;
        }
        System.out.println(result);
    }
}