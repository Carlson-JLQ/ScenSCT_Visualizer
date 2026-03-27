// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6_Var3 extends OutputStream {
    // Write method with byte parameter, but with an unused local variable
    public void write(byte b) throws IOException {
        byte copy = b;
        // Parameter type remains byte
    }
    
    @Override
    public void write(int b) {
        // Override without throws clause (IOException is not checked for write(int)? Actually it is declared in OutputStream, but we can choose not to throw)
        // This still satisfies the abstract method
    }
    
    // Add a static initializer block that does nothing
    static {
        int dummy = 42;
    }
}