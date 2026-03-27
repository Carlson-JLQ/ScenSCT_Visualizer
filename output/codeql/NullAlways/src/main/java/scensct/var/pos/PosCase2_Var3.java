// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        Object obj = getPossiblyNull();
        // Invert logic: check non-null first, but dereference in else block
        if (obj != null) {
            // Do nothing
        } else {
            obj.toString(); // [REPORTED LINE]
        }
    }
    
    private static Object getPossiblyNull() {
        return null;
    }
}