// Left-shift with int left operand and constant shift >= 32 should be flagged as shift amount truncated modulo 32.
package scensct.var.pos;

public class PosCase1_Var2 {
    private static final int SHIFT = 32;
    
    public static void main(String[] args) {
        int x = 5;
        int result = x << SHIFT; // [REPORTED LINE]
        System.out.println(result);
    }
}