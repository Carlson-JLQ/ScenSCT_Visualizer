// UUID from insecure random data has toString() called and the string flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.ref.pos;

import java.util.Random;
import java.util.UUID;

public class PosCase6_FN1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        String uuidStr = uuid.toString(); // toString() called
        generateSessionToken(uuidStr); // Flow into sensitive sink
    }

    static void generateSessionToken(String token) {
        // Simulate sensitive sink
    }
}