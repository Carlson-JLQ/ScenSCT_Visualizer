// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var4 {
    // Variant 4: Intra-procedural with try-catch-finally, but resource still escapes.
    public InputStream test() throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test.txt");
            // Possibly do something non-closing.
            int firstByte = fis.read();
            // Ignore the byte, resource still open.
        } catch (IOException e) {
            // Re-throw, but if we caught, we must ensure resource escapes? Actually, we re-throw, so fis may be null or set.
            // To keep invariant, we ensure fis is returned in all paths.
            if (fis != null) {
                throw e; // fis remains open and escapes? Not yet. We need to return it.
                // This is tricky: we must return fis even on exception? But method throws IOException.
                // Instead, restructure to always return.
            }
            throw e;
        } finally {
            // Finally block without closing, but we return the resource.
            // Actually, we cannot return from finally and method. So adjust.
        }
        return fis; // fis escapes here.
    }
}