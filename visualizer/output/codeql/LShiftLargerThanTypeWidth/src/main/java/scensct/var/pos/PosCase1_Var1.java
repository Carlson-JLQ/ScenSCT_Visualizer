// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        int value = 5;
        int shiftAmount = 32;
        int shifted = value << shiftAmount;
        System.out.println(shifted);
    }
}