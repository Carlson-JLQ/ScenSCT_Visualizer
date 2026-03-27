// A recognized deserialization sink receives untrusted data, but the sink is a safe variant or used in a safe context should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase3 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a network input stream
        java.net.URL url = new java.net.URL("http://example.com/data");
        java.io.InputStream untrustedStream = url.openStream();
        
        // Safe variant: ValidatingObjectInputStream with allowed classes
        // This is a recognized safe context per pattern exceptions
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject("test");
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        
        // Using ValidatingObjectInputStream which validates classes before deserialization
        com.exp.ValidatingObjectInputStream vois = new com.exp.ValidatingObjectInputStream(bis);
        vois.accept(String.class); // Only allow String class
        Object obj = vois.readObject(); // Safe due to validation
        vois.close();
    }
}