// Multiplication of two int constants whose product definitely exceeds Integer.MAX_VALUE, then implicitly converted to long should be flagged as overflow.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use final variables to hold constants, still compile-time int constants
        final int a = 1000000;
        final int b = 3000000;
        long result = a * b; // Overflow occurs in int multiplication before widening // [REPORTED LINE]
        System.out.println(result);
    }
}