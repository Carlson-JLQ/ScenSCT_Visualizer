// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.core.pos;

public class PosCase1 {
    public static void main(String[] args) {
        Object obj = null; // Direct null assignment
        obj.toString();    // Dereference without reassignment // [REPORTED LINE]
    }
}