// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Idiomatic: use ternary to express null check, but discard result
        String v = null;
        boolean checked = (v == null) ? true : false;
        v = "now non-null";
        // Dereference via method reference
        java.util.function.Supplier<Integer> lenSupplier = v::length;
        System.out.println(lenSupplier.get());
    }
}