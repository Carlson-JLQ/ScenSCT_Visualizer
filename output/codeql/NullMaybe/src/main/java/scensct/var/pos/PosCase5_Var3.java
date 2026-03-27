// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.var.pos;

public class PosCase5_Var3 {
    public void test() {
        callMethod(null);
    }
    
    private void callMethod(String param) {
        // Loop that executes exactly once, dereferencing inside
        for (int i = 0; i < 1; i++) {
            System.out.println(param.length()); // [REPORTED LINE]
        }
    }
}