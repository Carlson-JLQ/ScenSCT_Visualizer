// Method called with null argument, parameter dereferenced in block where first dereference is of different variable should be flagged.
package scensct.var.pos;

public class PosCase6_Var2 {
    public void test() {
        callMethod(null);      // Null argument
    }
    
    private void callMethod(String param) {
        String alias = param;
        String safe = "test";
        try {
            System.out.println(safe.length()); // First dereference in block (different variable)
        } finally {
            System.out.println(alias.length()); // Dereference of alias of 'param' after first dereference
        }
    }
}