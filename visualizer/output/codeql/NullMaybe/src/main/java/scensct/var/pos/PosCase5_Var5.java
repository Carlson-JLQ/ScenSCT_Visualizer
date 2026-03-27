// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.var.pos;

public class PosCase5_Var5 {
    public void test() {
        callMethod(null);
    }
    
    private void callMethod(String param) {
        // Dereference after a side-effect free method call on param, but still first dereference
        param.toString(); // This is also a dereference, but it's the first one now // [REPORTED LINE]
        // Actually, that would change the first dereference, breaking the invariant.
        // Instead, we split the dereference across expressions.
        int len = param.length(); // First dereference
        System.out.println("Length: " + len);
    }
}