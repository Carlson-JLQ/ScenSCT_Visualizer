// Insecure random data passed to UUID constructor and resulting UUID flows into a credentials sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PosCase2 {
    public static void main(String[] args) throws Exception {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        Connection conn = null; // Simulated connection
        if (conn != null) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password=? WHERE id=1");
            stmt.setString(1, uuid.toString()); // Credentials sink
        }
    }
}