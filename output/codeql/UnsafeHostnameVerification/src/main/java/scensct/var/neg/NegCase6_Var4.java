// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_Var4 {
    // Variant 4: Extract verification logic to a separate method, use method reference
    static boolean checkHost(String hostname, SSLSession session) {
        // session parameter unused but required for signature compatibility
        return hostname != null && (hostname.equals("localhost") 
            || hostname.endsWith(".trusted.example.com"));
    }

    static HostnameVerifier buildVerifier() {
        // Method reference as HostnameVerifier
        return NegCase6_Var4::checkHost;
    }

    public static void main(String[] args) throws Exception {
        try {
            HostnameVerifier verifier = buildVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink
        } finally {
            // Irrelevant cleanup
        }
    }
}