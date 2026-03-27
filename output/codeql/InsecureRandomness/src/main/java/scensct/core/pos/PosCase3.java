// Insecure random data passed to UUID constructor and resulting UUID flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import java.util.UUID;
import javax.servlet.http.HttpSession;

public class PosCase3 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        HttpSession session = null; // Simulated session
        if (session != null) {
            session.setAttribute("token", uuid.toString()); // Sensitive sink (session token)
        }
    }
}