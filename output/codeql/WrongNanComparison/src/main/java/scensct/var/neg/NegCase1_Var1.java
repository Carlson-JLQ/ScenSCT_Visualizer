// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Swap operands and use Float NaN
        float f1 = Float.NaN;
        float f2 = Float.intBitsToFloat(0x7fc00000); // Another NaN representation
        boolean res = (f2 == f1); // Still no field access
        System.out.println(res);
    }
}