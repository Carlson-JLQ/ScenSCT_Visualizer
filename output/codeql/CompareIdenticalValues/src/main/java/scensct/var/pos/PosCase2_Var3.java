// Comparison with identical variable accesses should be flagged as identical operands.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        int x = 10;
        boolean b1 = compareNotEqual(x, x);
        
        Object obj = new Object();
        boolean b2 = compareEqual(obj, obj);
        
        Holder h = new Holder();
        boolean b3 = compareGreaterOrEqual(h.value, h.value);
    }
    
    static boolean compareNotEqual(int a, int b) {
        return a != b;
    }
    
    static boolean compareEqual(Object a, Object b) {
        return a == b;
    }
    
    static boolean compareGreaterOrEqual(int a, int b) {
        return a >= b;
    }
    
    static class Holder {
        int value = 5;
    }
}