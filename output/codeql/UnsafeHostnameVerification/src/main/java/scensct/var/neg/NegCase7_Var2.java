// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase7_Var2 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    static Object createAndWrap() {
        // Helper returns Object, obscuring the runtime type
        return new AlwaysTrueVerifier();
    }

    public static void main(String[] args) throws Exception {
        // Variant 2: Creation hidden in helper method returning Object
        Object obj = createAndWrap();
        // No further use as HostnameVerifier
        if (obj instanceof HostnameVerifier) {
            // Checker must see that cast is not used to install
            HostnameVerifier v = (HostnameVerifier) obj;
            // Still not passed to setDefaultHostnameVerifier
        }
    }
}