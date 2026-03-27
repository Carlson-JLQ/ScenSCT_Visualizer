// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.var.neg;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Aliasing through a method parameter
        String v = "non-null";
        String other = null;
        printLength(v); // v's non-nullness preserved through method call
    }

    private static void printLength(String param) {
        // param is definitely non-null here (passed from v)
        System.out.println(param.length());
    }
}