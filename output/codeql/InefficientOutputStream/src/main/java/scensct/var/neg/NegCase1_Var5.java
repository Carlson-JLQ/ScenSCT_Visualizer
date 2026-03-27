// Abstract class should not be flagged as concrete class overriding only write(int).
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public abstract class NegCase1_Var5 extends OutputStream {
    /**
     * Writes a single byte.
     */
    @Override
    public abstract void write(int b) throws IOException;
    
    // This class is deliberately abstract.
}