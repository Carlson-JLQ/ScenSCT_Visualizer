// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        int x = 10;
        int y = x; // alias
        boolean b1 = y != x; // still same variable value
        
        Object obj = new Object();
        Object ref = obj;
        boolean b2 = ref == obj; // same reference
        
        Holder h = new Holder();
        int val = h.value;
        boolean b3 = val >= h.value; // same field value
    }
    
    static class Holder {
        int value = 5;
    }
}