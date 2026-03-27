// Untrusted data flows to a dangerous deserialization sink, but the flow passes through a new JsonIoJsonReader constructor call acting as a safe barrier should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase6 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a network connection
        java.net.Socket socket = new java.net.Socket("example.com", 80);
        java.io.InputStream untrustedStream = socket.getInputStream();
        byte[] untrustedData = untrustedStream.readAllBytes();
        String untrustedStr = new String(untrustedData);
        
        // Safe barrier: JsonIoJsonReader constructor
        // This reader provides safe JSON parsing
        com.exp.JsonIoJsonReader reader = new com.exp.JsonIoJsonReader(untrustedStr);
        com.exp.MyClass safeObj = reader.read(com.exp.MyClass.class);
        
        // Dangerous deserialization sink
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(safeObj); // safeObj is safe after JsonIoJsonReader barrier
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject(); // Safe due to barrier
        ois.close();
    }
}