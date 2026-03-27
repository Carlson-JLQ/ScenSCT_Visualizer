// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase7_Var5 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    static void unusedSink(HostnameVerifier v) {
        // Method looks like a sink but is never called
        HttpsURLConnection.setDefaultHostnameVerifier(v); // [REPORTED LINE]
    }

    public static void main(String[] args) throws Exception {
        // Variant 5: Create verifier, cast to Object, then back but only for a no-op
        Object obj = new AlwaysTrueVerifier();
        // Dead branch: condition always false
        if (args.length < 0) {
            HostnameVerifier v = (HostnameVerifier) obj;
            unusedSink(v); // Unreachable
        }
        // Real control flow never installs
    }
}