// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring - use a temporary variable that holds null
        Object temp = null;
        Object obj = temp;
        obj.toString();
    }
}