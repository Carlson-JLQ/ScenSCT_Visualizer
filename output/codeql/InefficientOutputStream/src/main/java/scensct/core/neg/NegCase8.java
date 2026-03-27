// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8 extends OutputStream {
    // Declares write(int).
    @Override
    public void write(int b) throws IOException {
        // Method body.
    }
    // This class inherits the three-parameter write from OutputStream, which is declared in OutputStream.
    // To satisfy the scenario, we need a class where the inherited three-parameter write is not from OutputStream/FilterOutputStream.
    // We create an intermediate class that provides a three-parameter write, then extend it.
    public static class Intermediate extends OutputStream {
        // Declare a three-parameter write method.
        public void write(byte[] b, int off, int len) throws IOException {
            // This method is not from OutputStream because we override it.
        }
        @Override
        public void write(int b) throws IOException {
            // Required abstract method implementation.
        }
    }
    public static class NegCase8Inner extends Intermediate {
        @Override
        public void write(int b) throws IOException {
            // Declares write(int).
        }
        // Inherits the three-parameter write from Intermediate, not from OutputStream/FilterOutputStream.
    }
}