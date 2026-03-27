// UUID from insecure random data has toString() called and the string flows into a credentials sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import java.util.UUID;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PosCase5 {
    public static void main(String[] args) throws Exception {
        Random insecureRand = new Random(); // Insecure random source
        long mostSigBits = insecureRand.nextLong();
        long leastSigBits = insecureRand.nextLong();
        UUID uuid = new UUID(mostSigBits, leastSigBits); // UUID constructed from insecure data
        String uuidStr = uuid.toString(); // toString() called
        Connection conn = null; // Simulated connection
        if (conn != null) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE users SET password=? WHERE id=1");
            stmt.setString(1, uuidStr); // Credentials sink (password setting in SQL)
        }
    }
}