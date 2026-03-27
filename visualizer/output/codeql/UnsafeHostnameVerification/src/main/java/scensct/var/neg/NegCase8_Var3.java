// A HostnameVerifier that always returns true is set as default but guarded by a security feature flag check should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase8_Var3 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    private static void setupInsecureVerifier() {
        HostnameVerifier verifier = new AlwaysTrueVerifier();
        HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
    }

    public static void main(String[] args) throws Exception {
        boolean debug = Boolean.parseBoolean(args.length > 0 ? args[0] : "false");
        if (!debug) {
            return; // Early exit, sink never reached
        }
        setupInsecureVerifier();
    }
}