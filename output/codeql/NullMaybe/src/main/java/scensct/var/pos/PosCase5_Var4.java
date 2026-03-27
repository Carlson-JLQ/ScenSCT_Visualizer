// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.var.pos;

public class PosCase5_Var4 {
    public void test() {
        callMethod(null);
    }
    
    private void callMethod(String param) {
        // Try-catch block, dereference in try
        try {
            System.out.println(param.length()); // [REPORTED LINE]
        } catch (RuntimeException e) {
            throw e;
        }
    }
}