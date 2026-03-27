// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7_Var4 extends OutputStream {
    // Use an interface to add extra behavior without affecting inheritance.
    private final Logger logger = new ConsoleLogger();
    
    @Override
    public void write(int b) throws IOException {
        logger.log("Writing byte: " + b);
    }
    
    // Inner interface and class.
    private interface Logger {
        void log(String message);
    }
    
    private static class ConsoleLogger implements Logger {
        @Override
        public void log(String message) {
            System.out.println(message);
        }
    }
}