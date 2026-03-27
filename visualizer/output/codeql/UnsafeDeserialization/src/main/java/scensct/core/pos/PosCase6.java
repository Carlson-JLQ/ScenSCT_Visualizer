// Untrusted data flows into a deserialization sink via Jodd parse with Class<Object> argument and Flexjson calls where tainted data is not the argument.
package scensct.core.pos;

import jodd.json.JsonParser;
import flexjson.JSONDeserializer;

import java.io.InputStream;

public class PosCase6 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // Jodd parse with Class<Object> argument
        JsonParser parser = new JsonParser();
        Object intermediate = parser.parse(untrustedJson, Object.class); // Taint flows through
        
        // Flexjson deserialize where tainted data is not the class argument
        JSONDeserializer<String> deserializer = new JSONDeserializer<>();
        // The tainted intermediate is passed as the data argument, not the class argument
        String deserialized = deserializer.deserialize((String) intermediate, String.class); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}