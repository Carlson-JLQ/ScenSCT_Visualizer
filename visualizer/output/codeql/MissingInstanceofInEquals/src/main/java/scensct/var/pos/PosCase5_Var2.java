// equals method without type test returns equality between parameter and another parameter should be flagged as bug.
package scensct.var.pos;

import java.util.Objects;

public class PosCase5_Var2 {
    @Override
    public boolean equals(Object obj) {
        // Variant 2: Use Objects.equals but with a fresh local object, still no type test.
        // Objects.equals does a null check and equals call, but here both sides are non-null and distinct objects.
        final Object local = new Object();
        return Objects.equals(obj, local); // This still compares obj with local without instanceof.
    }
}