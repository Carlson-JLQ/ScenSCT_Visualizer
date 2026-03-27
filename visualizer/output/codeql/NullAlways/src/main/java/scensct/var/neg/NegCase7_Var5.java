// Dereference in block guarded by null check where variable's ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase7_Var5 {
    private static void derefIfNull(Object o) {
        if (o == null) {
            System.out.println(o.toString()); // [REPORTED LINE]
        }
    }
    
    public static void main(String[] args) {
        Object local = new Object();
        derefIfNull(local); // Method call: guard inside helper, still always false
    }
}