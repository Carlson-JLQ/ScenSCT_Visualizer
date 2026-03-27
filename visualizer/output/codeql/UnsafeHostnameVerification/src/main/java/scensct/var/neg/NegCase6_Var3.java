// A HostnameVerifier instance reaches a sensitive sink but the source is not a class instance creation expression should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase6_Var3 {
    // Variant 3: Refactor with helper class and aliasing
    private static final class TrustedHostVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return hostname != null && (hostname.equals("localhost") 
                || hostname.endsWith(".trusted.example.com"));
        }
    }

    static HostnameVerifier fetchVerifier() {
        TrustedHostVerifier thv = new TrustedHostVerifier(); // New expression here, but not in main flow
        return thv; // Returned
    }

    public static void main(String[] args) throws Exception {
        HostnameVerifier v1 = fetchVerifier();
        HostnameVerifier v2 = v1; // Alias
        HttpsURLConnection.setDefaultHostnameVerifier(v2); // Sink via alias
    }
}