// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9_Var4 extends OutputStream {
    // Variant 4: Switch statement and local class (outside write method)
    @Override
    public void write(int b) throws IOException {
        switch (b & 0x03) {
            case 0:
                int x = b + 1;
                break;
            case 1:
                int y = b - 1;
                break;
            default:
                int z = b * 2;
        }
    }

    // Helper inner class doesn't affect the witness
    private static class Buffer {
        byte[] data;
    }
}