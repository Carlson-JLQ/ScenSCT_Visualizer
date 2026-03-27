// Untrusted data flows into a deserialization sink via Jodd parse without typed class argument and Flexjson deserialize with tainted data argument and Class<Object> type class.
package scensct.core.pos;

import jodd.json.JsonParser;
import flexjson.JSONDeserializer;

import java.io.InputStream;

public class PosCase7 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // Jodd parse without typed class argument
        JsonParser parser = new JsonParser();
        Object intermediate = parser.parse(untrustedJson); // Taint flows through
        
        // Flexjson deserialize where tainted data is the argument and type class is Class<Object>
        JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
        Object deserialized = deserializer.deserialize((String) intermediate, Object.class); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}