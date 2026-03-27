// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) {
        // Variant 4: Idiomatic variation - Use Optional to wrap, but immediately get non-null
        java.util.Optional<Object> opt = java.util.Optional.of(new Object());
        Object local = opt.get(); // get() on a non-empty Optional returns non-null
        System.out.println(local.toString());
    }
}