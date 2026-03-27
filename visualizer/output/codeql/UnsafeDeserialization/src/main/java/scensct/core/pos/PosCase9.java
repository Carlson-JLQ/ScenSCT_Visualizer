// Untrusted data flows into a deserialization sink via JsonIo reader, Jodd parse with null type class argument, and Flexjson deserialize with tainted data argument and no type class.
package scensct.core.pos;

import com.cedarsoftware.util.io.JsonReader;
import jodd.json.JsonParser;
import flexjson.JSONDeserializer;

import java.io.InputStream;

public class PosCase9 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // JsonIo reader (non-constructor barrier)
        JsonReader reader = new JsonReader(untrustedJson);
        Object intermediate1 = reader.readObject(); // Taint flows through
        
        // Jodd parse with null type class argument
        JsonParser parser = new JsonParser();
        Object intermediate2 = parser.parse((String) intermediate1, null); // Taint flows through
        
        // Flexjson deserialize where tainted data is the argument and no type class specified
        JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
        Object deserialized = deserializer.deserialize((String) intermediate2); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}