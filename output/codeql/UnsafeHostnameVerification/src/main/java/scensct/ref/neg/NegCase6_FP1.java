// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.ref.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_FP1 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    static HostnameVerifier getVerifier() {
        return new AlwaysTrueVerifier(); // Source is method return, not direct new expression in flow
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier verifier = getVerifier(); // Obtained via method call
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // Sink // [REPORTED LINE]
        // Source is not a class instance creation expression in the flow, so no violation
    }
}