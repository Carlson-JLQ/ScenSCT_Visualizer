// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import javax.servlet.http.HttpSession;

public class PosCase8 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        String insecureData = Long.toString(insecureRand.nextLong());
        String encoded = encodeForSQL(insecureData); // ESAPI encode method, insecure data as first argument
        HttpSession session = null; // Simulated session
        if (session != null) {
            session.setAttribute("token", encoded); // Sensitive sink
        }
    }

    static String encodeForSQL(String input) {
        // Simulate OWASP ESAPI Encoder method
        return "encoded_" + input;
    }
}