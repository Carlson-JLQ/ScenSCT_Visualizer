// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try-catch block that doesn't affect nullness
        Object obj = null;
        try {
            // No assignment to obj in try block
        } catch (Exception e) {
            // Still no assignment
        }
        obj.toString(); // [REPORTED LINE]
    }
}