// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        // Reordered and wrapped in if
        Holder h = new Holder();
        if (true) {
            boolean b3 = h.value >= h.value; // [REPORTED LINE]
        }
        
        int x = 10;
        boolean b1 = x != x; // [REPORTED LINE]
        
        Object obj = new Object();
        boolean b2 = (obj == obj); // [REPORTED LINE]
    }
    
    static class Holder {
        int value = 5;
    }
}