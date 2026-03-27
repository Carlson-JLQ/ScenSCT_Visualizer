// Insecure randomness sanitized by ESAPI encode should not be flagged as insecure randomness usage.
package scensct.core.neg;

import java.util.Random;
// Assuming ESAPI Encoder is available; using placeholder.
import com.exp.AnotherClass; // Placeholder for ESAPI Encoder.

public class NegCase7 {
    public static void main(String[] args) {
        // Insecure random source.
        Random rand = new Random();
        int insecureNum = rand.nextInt();
        // Sanitize using ESAPI encode method (placeholder).
        String sanitized = AnotherClass.encodeForHTML(String.valueOf(insecureNum)); // Breaks taint flow.
        // Flow to sensitive sink (e.g., hypothetical setCookie) with sanitized data.
        // setCookie(sanitized); // Hypothetical sensitive sink.
    }
}