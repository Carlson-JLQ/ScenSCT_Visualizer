// A method with inner if condition not being == null check should not be flagged as double-checked locking.
package scensct.var.neg;

import java.util.Objects;

public class NegCase6_Var2 {
    private static Object cache; // static non-volatile field

    public void method() {
        if (cache == null) {
            synchronized (NegCase6_Var2.class) { // synchronized on class object
                Object localInstance = "dummy";
                if (Objects.equals(cache, localInstance)) { // inner condition using Objects.equals
                    cache = new String("initialized");
                }
            }
        }
    }
}