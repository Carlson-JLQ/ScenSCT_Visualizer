// Equality test where neither operand is a field access expression should not be flagged as static NaN comparison.
package scensct.var.neg;

public class NegCase1_Var2 {
    private static double getNaN() {
        return Math.sqrt(-1.0); // Produces NaN via library call
    }
    
    public static void main(String[] args) {
        // Variant 2: Extract NaN production to a method
        double x = getNaN();
        double y = Double.longBitsToDouble(0x7ff8000000000000L); // Quiet NaN
        boolean test = (x == y); // Operands are method returns, not field accesses
        System.out.println(test);
    }
}