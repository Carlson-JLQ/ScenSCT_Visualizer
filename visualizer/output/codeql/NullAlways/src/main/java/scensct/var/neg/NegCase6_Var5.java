// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try-finally with no effect on nullness
        Object x = new Object();
        try {
            // Some operation that doesn't change x
            int dummy = x.hashCode();
        } finally {
            // Finally block runs, but guard still false
            if (x == null) {
                System.out.println(x.toString());
            }
        }
    }
}