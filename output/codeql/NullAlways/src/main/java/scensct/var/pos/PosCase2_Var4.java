// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        Object obj = getPossiblyNull();
        // Extract dereference into a helper method, passing the null variable
        processNull(obj);
    }
    
    private static void processNull(Object o) {
        if (o == null) {
            o.toString(); // [REPORTED LINE]
        }
    }
    
    private static Object getPossiblyNull() {
        return null;
    }
}