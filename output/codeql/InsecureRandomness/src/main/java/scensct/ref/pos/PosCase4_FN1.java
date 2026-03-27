// Insecure random data passed to UUID constructor and resulting UUID flows into a SetCookieValue sink should be flagged as insecure randomness usage.
package scensct.ref.pos;

import java.util.Random;
import java.util.UUID;

public class PosCase4_FN1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        setCookie("sessionId", uuid.toString()); // Flow into SetCookieValue sink
    }

    static void setCookie(String name, String value) {
        // Simulate SetCookieValue sink
    }
}