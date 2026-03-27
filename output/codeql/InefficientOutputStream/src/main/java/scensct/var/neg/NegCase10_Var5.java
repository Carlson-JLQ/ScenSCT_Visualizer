// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10_Var5 extends OutputStream {
    // Transform: use a switch expression (Java 14+) to call helper
    @Override
    public void write(int b) throws IOException {
        String result = switch (Integer.signum(b)) {
            case -1 -> { yield handleNegative(); }
            case 0 -> { yield handleZero(); }
            case 1 -> { yield handlePositive(); }
            default -> "unknown";
        };
        // result ignored
    }

    private String handleNegative() { return "neg"; }
    private String handleZero() { return "zero"; }
    private String handlePositive() { return "pos"; }

    // Add a default constructor with a call
    public NegCase10_Var5() {
        super();
    }
}