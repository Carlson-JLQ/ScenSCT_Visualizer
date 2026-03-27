// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7_Var3 extends OutputStream {
    // Extract the write logic to a private method and call it.
    @Override
    public void write(int b) throws IOException {
        internalWrite(b);
    }
    
    private void internalWrite(int b) throws IOException {
        // Core logic remains empty.
    }
    
    // Override another method from OutputStream to show multiple overrides.
    @Override
    public void close() throws IOException {
        super.close();
    }
}