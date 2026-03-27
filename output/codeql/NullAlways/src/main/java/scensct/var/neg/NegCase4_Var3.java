// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase4_Var3 {
    public static void main(String[] args) {
        // Variant 3: Inter-procedural - Move dereference into a helper method
        Object local = new Object();
        invokeToString(local);
    }

    private static void invokeToString(Object obj) {
        // obj is non-null because caller passes a non-null reference
        System.out.println(obj.toString());
    }
}