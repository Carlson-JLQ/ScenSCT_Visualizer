// Creating a ByteArrayInputStream (safe in-memory stream) should not be flagged as a resource leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;

public class NegCase2_Var5 {
    public void test() {
        // Variant 5: Use a static factory-like pattern via a method that returns the stream.
        ByteArrayInputStream stream = makeStream();
        // No close; safe.
    }
    
    private ByteArrayInputStream makeStream() {
        return new ByteArrayInputStream(new byte[10]);
    }
}