// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.var.pos;

public class PosCase2_Var5 {
    public static void main(String[] args) {
        // Loop that doesn't affect comparison
        for (int i = 0; i < 1; i++) {
            int x = 10;
            boolean b1 = x != x; // [REPORTED LINE]
        }
        
        Object obj = new Object();
        // Temporary variable with same reference
        Object tmp = obj;
        boolean b2 = tmp == obj;
        
        Holder h = new Holder();
        // Multiple identical accesses
        int v1 = h.value;
        int v2 = h.value;
        boolean b3 = v1 >= v2;
    }
    
    static class Holder {
        int value = 5;
    }
}