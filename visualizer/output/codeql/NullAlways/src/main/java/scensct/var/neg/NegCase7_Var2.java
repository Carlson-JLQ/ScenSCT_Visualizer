// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        Object local = new Object();
        boolean flag = (local == null); // flag is always false
        if (flag) { // Guard via temporary variable
            System.out.println(local.toString());
        }
    }
}