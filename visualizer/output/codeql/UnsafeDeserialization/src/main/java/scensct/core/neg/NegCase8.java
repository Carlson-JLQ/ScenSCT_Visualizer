// Untrusted data flows to a dangerous deserialization sink, but the flow passes through a Jodd JsonParser parse call with a specific, non-Object type class argument acting as a safe barrier should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase8 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a file
        FileInputStream fis = new FileInputStream("untrusted.json");
        byte[] untrustedBytes = fis.readAllBytes();
        fis.close();
        String untrustedJson = new String(untrustedBytes);
        
        // Safe barrier: Jodd JsonParser with specific type
        // This provides type-safe JSON parsing
        com.exp.MyClass obj = new com.exp.JsonParser()
            .parse(untrustedJson, com.exp.MyClass.class);
        
        // Dangerous deserialization sink
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj); // obj is safe after Jodd JsonParser barrier
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object deserialized = ois.readObject(); // Safe due to barrier
        ois.close();
    }
}