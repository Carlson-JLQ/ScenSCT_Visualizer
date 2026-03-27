// Insecure random data passed to UUID constructor and resulting UUID flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.ref.pos;

import java.util.Random;
import java.util.UUID;

public class PosCase3_FN1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        generateSessionToken(uuid.toString()); // Flow into sensitive sink (session token)
    }

    static void generateSessionToken(String token) {
        // Simulate sensitive sink
    }
}