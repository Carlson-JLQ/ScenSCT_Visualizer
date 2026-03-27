// Untrusted data flows to a node, and there exists a dangerous deserialization call, but the sink expression for the untrusted data is not the qualifier or an argument of that call should not be flagged as unsafe deserialization.
package scensct.core.neg;

import java.io.*;

public class NegCase4 {
    public static void main(String[] args) throws Exception {
        // Untrusted source: reading from a socket
        java.net.Socket socket = new java.net.Socket("example.com", 80);
        java.io.InputStream untrustedStream = socket.getInputStream();
        byte[] untrustedData = untrustedStream.readAllBytes();
        
        // Untrusted data flows to a node (stored in a variable)
        String dataStr = new String(untrustedData);
        
        // Dangerous deserialization sink exists nearby
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject("safe object");
        oos.close();
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        // But the untrusted data (dataStr) is NOT used as qualifier or argument here
        Object obj = ois.readObject(); // Reads from bis, not from untrusted data
        ois.close();
        
        // The untrusted data is used elsewhere, not in the deserialization call
        System.out.println(dataStr.length());
    }
}