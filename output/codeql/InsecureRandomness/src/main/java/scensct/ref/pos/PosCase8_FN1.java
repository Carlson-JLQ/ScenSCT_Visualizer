// Insecure random data passed as first argument to OWASP ESAPI Encoder method and encoded result flows into a sensitive sink should be flagged as insecure randomness usage.
package scensct.ref.pos;

import java.util.Random;

public class PosCase8_FN1 {
    public static void main(String[] args) {
        Random insecureRand = new Random(); // Insecure random source
        String insecureData = Long.toString(insecureRand.nextLong());
        String encoded = encodeForSQL(insecureData); // ESAPI encode method, insecure data as first argument
        generateSessionToken(encoded); // Flow into sensitive sink
    }

    static String encodeForSQL(String input) {
        // Simulate OWASP ESAPI Encoder method
        return "encoded_" + input;
    }

    static void generateSessionToken(String token) {
        // Simulate sensitive sink
    }
}