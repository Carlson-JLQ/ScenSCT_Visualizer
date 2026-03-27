// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var6 {
    // Variant 4 (corrected): Use try-catch but ensure resource is returned.
    public InputStream test() throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        try {
            // Perform a trivial operation that might throw.
            fis.read(); // Could throw IOException, but we let it propagate.
        } catch (IOException e) {
            // On exception, we still return the open stream? But method throws IOException.
            // To preserve escape, we must return fis before throwing? That changes semantics.
            // Better: re-throw after ensuring fis is returned? Actually, we cannot both return and throw.
            // So we need a design where fis is returned in both normal and exceptional paths.
            // Let's restructure: catch, then throw, but fis is still open and will be returned? No.
            // Instead, we catch, then return fis? But method signature says throws IOException.
            // We can wrap the exception? That changes scenario.
            // To keep invariant, avoid catch that changes flow. Simpler: try-with-resources? That closes.
            // Therefore, I'll simplify: remove catch and just use try-finally without closing.
        } finally {
            // Do nothing, fis remains open.
        }
        return fis; // fis escapes.
    }
}