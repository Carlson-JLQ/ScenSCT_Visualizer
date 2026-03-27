// Multiplication by zero with integer literal zero operand should be flagged as always evaluating to zero.
package scensct.ref.pos;

public class PosCase1_FN1 {
    public PosCase1_FN1() {
        int nonConstant = getNonConstant(); // Non-constant subexpression
        int result = nonConstant * 0; // Multiplication by zero, always zero
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100); // Non-constant value
    }
}