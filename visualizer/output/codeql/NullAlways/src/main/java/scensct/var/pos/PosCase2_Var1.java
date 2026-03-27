// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        Object target = getPossiblyNull();
        if (target == null) {
            // Dereference moved to a separate statement but same condition
            String s = target.toString(); // [REPORTED LINE]
        }
    }
    
    private static Object getPossiblyNull() {
        return null;
    }
}