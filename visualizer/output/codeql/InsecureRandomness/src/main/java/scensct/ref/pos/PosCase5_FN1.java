// UUID from insecure random data has toString() called and the string flows into a credentials sink should be flagged as insecure randomness usage.
package scensct.ref.pos;

import java.util.Random;
import java.util.UUID;

public class PosCase5_FN1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        String uuidStr = uuid.toString(); // toString() called
        setUserPassword(uuidStr); // Flow into credentials sink
    }

    static void setUserPassword(String pwd) {
        // Simulate credentials sink
    }
}