// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.core.pos;

public class PosCase2 {
    public PosCase2() {
        int x = getNonConstant(); // Non-constant integral expression
        int result = x % 1; // Always zero for any integer x // [REPORTED LINE]
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100); // Non-constant value
    }
}