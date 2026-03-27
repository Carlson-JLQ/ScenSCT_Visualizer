// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.util.ArrayList;
import java.util.List;

public class NegCase7_Var1 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // Variant 1: Chain of assignments through supertype and wildcard collection
        HostnameVerifier verifier = new AlwaysTrueVerifier();
        Object obj1 = verifier;
        List<?> list = new ArrayList<>();
        // Cannot add to List<?> except null, so verifier never flows to a sink
        // This stresses type inference and collection handling
    }
}