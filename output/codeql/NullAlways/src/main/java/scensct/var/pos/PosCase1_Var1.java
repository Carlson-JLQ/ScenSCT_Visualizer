// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - split declaration and assignment
        Object obj;
        obj = null;
        obj.toString(); // [REPORTED LINE]
    }
}