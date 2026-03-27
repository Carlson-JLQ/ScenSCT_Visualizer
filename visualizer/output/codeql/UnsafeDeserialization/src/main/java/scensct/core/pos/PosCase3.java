// Untrusted data flows into a deserialization sink via JsonIo reader (non-constructor barrier) and Jodd parse with Class<Object> argument, no Flexjson calls.
package scensct.core.pos;

import com.cedarsoftware.util.io.JsonReader;
import jodd.json.JsonParser;

import java.io.InputStream;

public class PosCase3 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // JsonIo reader (non-constructor barrier)
        JsonReader reader = new JsonReader(untrustedJson);
        Object intermediate = reader.readObject(); // Taint flows through
        
        // Jodd parse with Class<Object> argument
        JsonParser parser = new JsonParser();
        Object deserialized = parser.parse((String) intermediate, Object.class); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}