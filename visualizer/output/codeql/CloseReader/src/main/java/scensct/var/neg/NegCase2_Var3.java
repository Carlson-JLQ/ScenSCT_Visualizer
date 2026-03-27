// Creating a ByteArrayInputStream (safe in-memory stream) should not be flagged as a resource leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;

public class NegCase2_Var3 {
    // Variant 3: Move creation to a helper method that returns void.
    private void createStream() {
        new ByteArrayInputStream(new byte[10]);
    }
    
    public void test() {
        createStream(); // The stream is created but not closed, still safe.
    }
}