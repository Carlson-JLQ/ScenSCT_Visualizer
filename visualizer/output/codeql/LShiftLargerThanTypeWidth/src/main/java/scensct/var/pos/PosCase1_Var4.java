// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.var.pos;

public class PosCase1_Var4 {
    private static int shift(int num) {
        return num << 32; // [REPORTED LINE]
    }
    
    public static void main(String[] args) {
        int x = 5;
        int result = shift(x);
        System.out.println(result);
    }
}