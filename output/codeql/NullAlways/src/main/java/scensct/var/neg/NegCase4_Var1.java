// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical & Intra-procedural - Split declaration and assignment, use temporary
        Object local;
        local = createNonNullObject();
        Object temp = local;
        System.out.println(temp.toString());
    }

    private static Object createNonNullObject() {
        return new Object();
    }
}