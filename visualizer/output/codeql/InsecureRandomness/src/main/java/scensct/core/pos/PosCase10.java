// Insecure random data flows to a sensitive sink via ESAPI encode method where insecure data is not the first argument should be flagged as insecure randomness usage.
package scensct.core.pos;

import java.util.Random;
import javax.servlet.http.HttpSession;

public class PosCase10 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        String insecureData = Long.toString(insecureRand.nextLong());
        String encoded = encodeForSQL("constant", insecureData, "extra"); // ESAPI encode method, insecure data as second argument
        HttpSession session = null; // Simulated session
        if (session != null) {
            session.setAttribute("token", encoded); // Sensitive sink
        }
    }

    static String encodeForSQL(String arg1, String arg2, String arg3) {
        // Simulate OWASP ESAPI Encoder method with multiple parameters
        return "encoded_" + arg2;
    }
}