// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7_Var5 extends OutputStream {
    // Introduce a final field and use it in write.
    private final boolean enabled = true;
    
    @Override
    public void write(int b) throws IOException {
        if (enabled) {
            // No-op.
        } else {
            throw new IOException("Disabled");
        }
    }
    
    // Add a constructor with parameters.
    public NegCase7_Var5(boolean enabled) {
        // Field is final, so this is just for show; real usage would require redesign.
    }
    
    public NegCase7_Var5() {
        this(true);
    }
}