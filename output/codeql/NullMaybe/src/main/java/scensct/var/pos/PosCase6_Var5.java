// Method called with null argument, parameter dereferenced in block where first dereference is of different variable should be flagged.
package scensct.var.pos;

public class PosCase6_Var5 {
    public void test() {
        callMethod(null);      // Null argument
    }
    
    private void callMethod(String param) {
        String other = "test";
        outer: do {
            System.out.println(other.length()); // First dereference in block (different variable)
            break outer;
        } while (false);
        // Still in same method scope, param unchanged
        System.out.println(param.length()); // Dereference of 'param' after first dereference // [REPORTED LINE]
    }
}