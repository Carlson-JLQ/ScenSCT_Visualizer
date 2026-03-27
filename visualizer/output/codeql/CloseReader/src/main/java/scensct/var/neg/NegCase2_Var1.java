// Creating a ByteArrayInputStream (safe in-memory stream) should not be flagged as a resource leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;

public class NegCase2_Var1 {
    public void test() {
        // Variant 1: Use a local variable with explicit type.
        ByteArrayInputStream stream = new ByteArrayInputStream(new byte[10]);
        // No close call; variable is unused but still safe.
    }
}