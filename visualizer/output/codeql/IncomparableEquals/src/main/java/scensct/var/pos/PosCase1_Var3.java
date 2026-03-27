// Top-level call to Object.equals with incomparable types should be flagged as positive.
package scensct.var.pos;

public class PosCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Intra-procedural control flow with dead branch
        String s = "foo";
        Integer i = 999;
        boolean result;
        if (System.currentTimeMillis() < 0) {
            // Dead branch, never executed
            result = true;
        } else {
            result = s.equals(i); // Live branch // [REPORTED LINE]
        }
    }
}