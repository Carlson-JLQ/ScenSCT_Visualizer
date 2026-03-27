// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7_Var1 extends OutputStream {
    // Lexical refactoring: change parameter name and add a local variable.
    @Override
    public void write(int byteValue) throws IOException {
        int b = byteValue & 0xFF;
        // Empty body, but with a local computation.
    }
    
    // Add a helper method that does not affect inheritance.
    public void log(String message) {
        System.out.println(message);
    }
}