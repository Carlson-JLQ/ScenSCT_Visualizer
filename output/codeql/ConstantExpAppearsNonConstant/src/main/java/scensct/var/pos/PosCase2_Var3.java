// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.var.pos;

public class PosCase2_Var3 {
    public PosCase2_Var3() {
        int val = getNonConstant();
        // Wrap in a trivial if-true block
        if (true) {
            int outcome = val % 1; // Pattern inside a block // [REPORTED LINE]
        }
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100);
    }
}