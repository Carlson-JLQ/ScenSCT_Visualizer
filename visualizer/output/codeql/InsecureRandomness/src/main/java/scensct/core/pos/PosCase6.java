// UUID from insecure random data has toString() called and the string flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpSession;

public class PosCase6 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        String uuidStr = uuid.toString(); // toString() called
        HttpSession session = null; // Simulated session
        if (session != null) {
            session.setAttribute("token", uuidStr); // Sensitive sink for session token
        }
    }
}