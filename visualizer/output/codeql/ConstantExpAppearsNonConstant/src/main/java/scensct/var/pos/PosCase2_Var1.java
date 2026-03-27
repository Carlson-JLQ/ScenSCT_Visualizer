// Remainder expression x % 1 with non-constant integral x inside constructor should be flagged as always zero.
package scensct.var.pos;

public class PosCase2_Var1 {
    public PosCase2_Var1() {
        int y = fetchValue(); // Renamed method and variable
        int computed = y % 1; // Same pattern, different names // [REPORTED LINE]
    }
    
    private int fetchValue() {
        return (int) (Math.random() * 1000); // Changed constant
    }
}