// Untrusted data flows into a deserialization sink via Jodd parse with specific typed class and Flexjson deserialize with tainted data argument and Class<Object> type class, JsonIo readers may be present.
package scensct.core.pos;

import com.cedarsoftware.util.io.JsonReader;
import jodd.json.JsonParser;
import flexjson.JSONDeserializer;

import java.io.InputStream;

public class PosCase8 {
    public void deserializeUntrustedData(InputStream untrustedStream) throws Exception {
        // Untrusted source
        String untrustedJson = new String(untrustedStream.readAllBytes());
        
        // JsonIo reader (non-constructor barrier) - optional per scenario
        JsonReader reader = new JsonReader(untrustedJson);
        Object intermediate1 = reader.readObject(); // Taint flows through
        
        // Jodd parse with specific typed class (String) where tainted data is not the class argument
        JsonParser parser = new JsonParser();
        Object intermediate2 = parser.parse((String) intermediate1, String.class); // Taint flows through
        
        // Flexjson deserialize where tainted data is the argument and type class is Class<Object>
        JSONDeserializer<Object> deserializer = new JSONDeserializer<>();
        Object deserialized = deserializer.deserialize((String) intermediate2, Object.class); // Sink with tainted data
        
        // Use deserialized object
        System.out.println(deserialized);
    }
}