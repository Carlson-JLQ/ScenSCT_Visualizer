// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.var.pos;

public class PosCase2_Var2 {
    public PosCase2_Var2() {
        int a = obtain();
        int temp = a;
        // Introduce an alias and use it in the remainder
        int res = temp % 1; // [REPORTED LINE]
    }
    
    private int obtain() {
        return (int) (Math.random() * 50);
    }
}