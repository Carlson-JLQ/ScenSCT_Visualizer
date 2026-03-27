// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.core.pos;

public class PosCase5 {
    public void test() {
        callMethod(null);      // Null argument
    }
    
    private void callMethod(String param) {
        // Block start
        {
            System.out.println(param.length()); // First dereference in block, no guard // [REPORTED LINE]
        }
    }
}