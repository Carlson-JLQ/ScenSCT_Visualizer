// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Control-flow restructuring with dead branch
        Object obj = null;
        if (false) {
            obj = new Object(); // Dead code, never executed
        }
        obj.toString(); // [REPORTED LINE]
    }
}