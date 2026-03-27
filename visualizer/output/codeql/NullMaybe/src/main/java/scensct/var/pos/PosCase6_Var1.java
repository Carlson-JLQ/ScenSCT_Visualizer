// Method called with null argument, parameter dereferenced in block where first dereference is of different variable should be flagged.
package scensct.var.pos;

public class PosCase6_Var1 {
    public void test() {
        invoke(null);      // Null argument
    }
    
    private void invoke(String arg) {
        String first = "test";
        // Block restructured
        if (true) {
            int len = first.length();   // First dereference in block (different variable)
            System.out.println(len);
            System.out.println(arg.length()); // Dereference of 'arg' after first dereference // [REPORTED LINE]
        }
    }
}