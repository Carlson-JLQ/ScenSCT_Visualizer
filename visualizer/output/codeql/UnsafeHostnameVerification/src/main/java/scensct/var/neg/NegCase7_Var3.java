// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase7_Var3 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // Variant 3: Assigned to array of Object, then conditionally ignored
        Object[] arr = new Object[2];
        arr[0] = new AlwaysTrueVerifier();
        for (Object o : arr) {
            if (o instanceof HostnameVerifier) {
                // Cast but break before any sink
                break;
            }
        }
        // Loop exits without installing
    }
}