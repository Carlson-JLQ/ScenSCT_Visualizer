// Method called with null argument, parameter dereferenced as first dereference in block without false null guard should be flagged.
package scensct.var.pos;

public class PosCase5_Var1 {
    public void test() {
        String input = null;
        callMethod(input); // Null argument via variable
    }
    
    private void callMethod(String param) {
        // Block with a preceding empty statement, but no guard
        ;
        {
            int len = param.length(); // Dereference assigned to local // [REPORTED LINE]
            System.out.println(len);
        }
    }
}