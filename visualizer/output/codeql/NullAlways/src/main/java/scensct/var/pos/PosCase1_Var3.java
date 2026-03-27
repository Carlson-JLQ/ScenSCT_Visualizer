// A local variable assigned only null values and later dereferenced without intervening reassignment should be flagged as always null dereference.
package scensct.var.pos;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - extract null assignment to a helper
    private static Object giveNull() {
        return null;
    }
    
    public static void main(String[] args) {
        Object obj = giveNull();
        obj.toString();
    }
}