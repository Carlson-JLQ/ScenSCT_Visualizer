// A local variable assigned a possibly null value is dereferenced inside a conditional block that checks for null without a non-null guard should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        Object obj = getPossiblyNull();
        // Restructure: use a temporary variable to hold the null check result
        boolean isNull = obj == null;
        if (isNull) {
            obj.toString(); // [REPORTED LINE]
        }
    }
    
    private static Object getPossiblyNull() {
        return null;
    }
}