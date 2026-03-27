// Abstract class should not be flagged as concrete class overriding only write(int).
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public abstract class NegCase1 extends OutputStream {
    // Abstract class, regardless of method overrides, is negative.
    @Override
    public abstract void write(int b) throws IOException;
}