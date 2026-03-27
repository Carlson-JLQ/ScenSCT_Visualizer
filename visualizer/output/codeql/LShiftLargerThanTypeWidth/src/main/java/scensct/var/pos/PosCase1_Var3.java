// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        int a = 5;
        int b;
        if (args.length > 0) {
            b = a << 32; // [REPORTED LINE]
        } else {
            b = a << 32; // [REPORTED LINE]
        }
        System.out.println(b);
    }
}