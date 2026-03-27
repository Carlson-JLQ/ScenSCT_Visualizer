// Dereference of a non-field variable guarded by explicit non-null check should not be flagged as always null.
package scensct.var.neg;

public class NegCase5_Var4 {
    public static void main(String[] args) {
        Object local = null;
        processIfNotNull(local);
    }

    private static void processIfNotNull(Object obj) {
        if (obj != null) {
            System.out.println(obj.toString());
        }
    }
}