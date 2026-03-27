// Multiplication by zero with integer literal zero operand should be flagged as always evaluating to zero.
package scensct.core.pos;

public class PosCase1 {
    public PosCase1() {
        int nonConstant = getNonConstant(); // Non-constant subexpression
        int result = nonConstant * 0; // Multiplication by zero, always zero
        // Use result in a conditional to emphasize constant evaluation
        if (result == 0) {
            // This branch is always taken
            System.out.println("Always zero");
        }
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100); // Non-constant value
    }
}