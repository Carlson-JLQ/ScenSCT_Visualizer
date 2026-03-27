// A dangerous deserialization sink exists, but there is no taint flow from the untrusted source to that sink should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase1 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a socket
        java.net.Socket socket = new java.net.Socket("example.com", 80);
        java.io.InputStream untrustedStream = socket.getInputStream();
        byte[] untrustedData = untrustedStream.readAllBytes();
        // This data is NOT used in the deserialization sink below
        
        // Dangerous deserialization sink: ObjectInputStream.readObject()
        // But it reads from a trusted, hardcoded source, not the untrusted data
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject("safe object");
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object obj = ois.readObject(); // No taint flow from untrustedData
        ois.close();
    }
}