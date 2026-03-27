// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        Object obj = new Object(); // Renamed variable
        if (obj != null) { // Guard inverted: always true, so else block is dead
            // Do nothing
        } else {
            // This block is unreachable because obj is non-null
            System.out.println(obj.toString());
        }
    }
}