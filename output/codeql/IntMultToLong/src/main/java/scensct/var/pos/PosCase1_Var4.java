// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use different constant representation (decimal unchanged) but introduce a temporary
        int factor1 = 1000000;
        int factor2 = 3000000;
        long result = factor1 * factor2; // Still int multiplication with constants via variables // [REPORTED LINE]
        System.out.println(result);
    }
}