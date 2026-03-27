// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_Var5 {
    // Variant 5: Factory pattern with conditional return (but always same safe verifier)
    static class VerifierFactory {
        static HostnameVerifier getDefault() {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    // Still safe
                    return hostname != null && 
                           (hostname.equalsIgnoreCase("localhost") || 
                            hostname.endsWith(".trusted.example.com"));
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier verifier = null;
        // Simple control flow that doesn't affect source
        for (int i = 0; i < 1; i++) {
            verifier = VerifierFactory.getDefault(); // Source is static factory call
        }
        if (verifier != null) {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink
        }
    }
}