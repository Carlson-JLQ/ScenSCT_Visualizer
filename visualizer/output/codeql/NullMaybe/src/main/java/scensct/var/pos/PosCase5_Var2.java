// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.var.pos;

public class PosCase5_Var2 {
    public void test() {
        callMethod(getNull()); // Null argument via helper
    }
    
    private String getNull() {
        return null;
    }
    
    private void callMethod(String param) {
        // Restructured control flow: if-else where both paths dereference param
        if (System.currentTimeMillis() > 0) {
            // This path always taken, but no null guard
            System.out.println(param.length()); // [REPORTED LINE]
        } else {
            // Dead code, also dereferences param
            System.out.println(param.length());
        }
    }
}