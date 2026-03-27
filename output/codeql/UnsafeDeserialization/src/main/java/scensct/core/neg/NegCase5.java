// Untrusted data flows to a dangerous deserialization sink, but the flow passes through a JsonIo.jsonToJava call acting as a safe barrier should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase5 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading JSON from a file
        FileInputStream fis = new FileInputStream("untrusted.json");
        byte[] untrustedBytes = fis.readAllBytes();
        fis.close();
        String untrustedJson = new String(untrustedBytes);
        
        // Safe barrier: JsonIo.jsonToJava() call with specific type
        // This acts as a safe deserialization barrier
        com.exp.MyClass obj = com.exp.JsonIo.jsonToJava(untrustedJson, com.exp.MyClass.class);
        
        // Dangerous deserialization sink: ObjectInputStream.readObject()
        // But it reads the safe object, not the untrusted data directly
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(obj); // obj is safe after JsonIo barrier
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object deserialized = ois.readObject(); // Safe due to barrier
        ois.close();
    }
}