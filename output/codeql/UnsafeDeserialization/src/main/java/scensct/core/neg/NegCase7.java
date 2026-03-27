// Untrusted data flows to a dangerous deserialization sink, but the flow passes through a Flexjson deserialize call with a specific, non-Object type class argument acting as a safe barrier should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase7 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading JSON string from a URL
        java.net.URL url = new java.net.URL("http://example.com/data.json");
        java.io.InputStream is = url.openStream();
        byte[] bytes = is.readAllBytes();
        is.close();
        String untrustedJson = new String(bytes);
        
        // Safe barrier: Flexjson JSONDeserializer with specific type
        // This provides type-safe JSON deserialization
        com.exp.MyClass obj = new com.exp.JSONDeserializer<com.exp.MyClass>()
            .deserialize(untrustedJson, com.exp.MyClass.class);
        
        // Dangerous deserialization sink
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj); // obj is safe after Flexjson barrier
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object deserialized = ois.readObject(); // Safe due to barrier
        ois.close();
    }
}