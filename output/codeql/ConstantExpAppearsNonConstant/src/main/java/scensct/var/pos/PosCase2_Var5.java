// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.var.pos;

public class PosCase2_Var5 {
    public PosCase2_Var5() {
        try {
            int x = getNonConstant();
            int result = x % 1; // Inside try block // [REPORTED LINE]
        } finally {
            // No-op finally
        }
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100);
    }
}