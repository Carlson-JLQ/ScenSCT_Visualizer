// Abstract class should not be flagged as concrete class overriding only write(int).
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

abstract class IntermediateStream extends OutputStream {
    @Override
    public abstract void write(int b) throws IOException;
}

public abstract class NegCase1_Var3 extends IntermediateStream {
    // No concrete method added
}