// Method called with null argument, parameter dereferenced in block where first dereference is of different variable should be flagged.
package scensct.var.pos;

public class PosCase6_Var3 {
    public void test() {
        callMethod(null);      // Null argument
    }
    
    private void callMethod(String param) {
        String other = "test";
        helper(other, param);
    }
    
    private void helper(String o, String p) {
        // Block start
        {
            System.out.println(o.length()); // First dereference in block (different variable)
            System.out.println(p.length()); // Dereference of 'p' after first dereference
        }
    }
}