// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_Var2 {
    // Variant 2: Anonymous class inside method, but returned via a wrapper method
    static HostnameVerifier provideVerifier() {
        HostnameVerifier hv = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                // Non-trivial check
                if (hostname == null) return false;
                return hostname.equals("localhost") || hostname.endsWith(".trusted.example.com");
            }
        };
        return hv;
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier verifier = provideVerifier(); // Source is method call
        // Add some irrelevant control flow
        if (args.length == 0) {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink
        } else {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Also sink, same instance
        }
    }
}