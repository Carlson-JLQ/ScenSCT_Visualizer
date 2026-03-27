// Creating a ByteArrayInputStream (safe in-memory stream) should not be flagged as a resource leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;

public class NegCase2_Var2 {
    public void test() {
        // Variant 2: Initialize byte array separately.
        byte[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        new ByteArrayInputStream(data);
    }
}