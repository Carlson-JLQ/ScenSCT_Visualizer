// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.core.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase7 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        Object obj = new AlwaysTrueVerifier(); // Assigned to Object supertype
        // Flow to sink with Object type, not HostnameVerifier
        // Checker may not recognize this as HostnameVerifier flow due to type
        // This should not trigger a violation
    }
}