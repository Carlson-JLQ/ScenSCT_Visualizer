// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        // Using var and Integer
        var x = Integer.valueOf(10);
        boolean b1 = x.intValue() != x.intValue();
        
        Object obj = new Object();
        boolean b2 = obj == obj; // [REPORTED LINE]
        
        Holder h = new Holder();
        // Access via method
        boolean b3 = getValue(h) >= getValue(h);
    }
    
    static int getValue(Holder h) {
        return h.value;
    }
    
    static class Holder {
        int value = 5;
    }
}