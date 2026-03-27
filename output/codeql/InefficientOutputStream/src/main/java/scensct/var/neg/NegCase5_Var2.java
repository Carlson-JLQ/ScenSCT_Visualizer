// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5_Var2 extends OutputStream {
    // Method with parameters, still not 'write'
    public void doWork(String task, int count) throws IOException {
        if (count > 0) {
            // Some dummy operation
        }
    }
    
    @Override
    public void write(int b) throws IOException {
        // Minimal
    }
}