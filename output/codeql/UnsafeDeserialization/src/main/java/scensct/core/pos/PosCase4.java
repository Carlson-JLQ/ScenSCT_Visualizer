// Untrusted data flows into a deserialization sink via JsonIo reader (non-constructor barrier) and Jodd parse with specific typed class where tainted data is not the argument.
package scensct.core.pos;

import com.cedarsoftware.util.io.JsonReader;
import jodd.json.JsonParser;

import java.io.InputStream;

public class PosCase4 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // JsonIo reader (non-constructor barrier)
        JsonReader reader = new JsonReader(untrustedJson);
        Object intermediate = reader.readObject(); // Taint flows through
        
        // Jodd parse with specific typed class (String) where tainted data is not the class argument
        JsonParser parser = new JsonParser();
        // The tainted intermediate is passed as the data argument, not the class argument
        String deserialized = parser.parse((String) intermediate, String.class); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}