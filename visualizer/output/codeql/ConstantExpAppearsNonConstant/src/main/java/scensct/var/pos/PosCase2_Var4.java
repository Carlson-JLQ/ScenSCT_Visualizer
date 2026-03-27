// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.var.pos;

public class PosCase2_Var4 {
    public PosCase2_Var4() {
        // Extract the remainder operation into a helper, but keep it called in constructor
        int z = getNonConstant();
        computeRemainder(z);
    }
    
    private void computeRemainder(int num) {
        int r = num % 1; // The pattern is now in a private method called from constructor // [REPORTED LINE]
    }
    
    private int getNonConstant() {
        return (int) (Math.random() * 100);
    }
}