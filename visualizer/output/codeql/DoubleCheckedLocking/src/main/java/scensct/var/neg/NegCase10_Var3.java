// A method implementing double-checked locking on non-volatile field of immutable type should not be flagged as unsafe.
package scensct.var.neg;

public class NegCase10_Var3 {
    private String f;

    public void method() {
        if (f == null) {
            // restructured: inner check extracted to a local variable
            synchronized (this) {
                boolean stillNull = (f == null);
                if (stillNull) {
                    f = new String("initialized"); // explicit constructor, still immutable
                }
            }
        }
    }
}