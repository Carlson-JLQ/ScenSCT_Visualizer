// Untrusted data flows into a deserialization sink via Jodd parse with specific typed class and Flexjson deserialize with tainted data argument but no type class.
package scensct.core.pos;

import jodd.json.JsonParser;
import flexjson.JSONDeserializer;

import java.io.InputStream;

public class PosCase5 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // Jodd parse with specific typed class (String) where tainted data is not the class argument
        JsonParser parser = new JsonParser();
        Object intermediate = parser.parse(untrustedJson, String.class); // Taint flows through
        
        // Flexjson deserialize where tainted data is the argument but no type class specified
        JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
        Object deserialized = deserializer.deserialize((String) intermediate); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}