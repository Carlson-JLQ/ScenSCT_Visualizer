// Multiplication with compile-time constant operands that cannot overflow before implicit widening should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    private static final int CONST_A = 100;
    private static final int CONST_B = 200;
    
    public static void main(String[] args) {
        long safe = multiplyConstants();
        System.out.println(safe);
    }
    
    private static long multiplyConstants() {
        return CONST_A * CONST_B;
    }
}