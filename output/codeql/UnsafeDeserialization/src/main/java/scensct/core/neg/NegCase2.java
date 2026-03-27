// A method call that is not a recognized unsafe deserialization sink receives untrusted data should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase2 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a file
        FileInputStream fis = new FileInputStream("untrusted.dat");
        byte[] untrustedBytes = fis.readAllBytes();
        fis.close();
        String untrustedStr = new String(untrustedBytes);
        
        // Non-deserialization sink: String.valueOf() - not a recognized unsafe deserialization sink
        String result = String.valueOf(untrustedStr); // Safe conversion, no deserialization
    }
}