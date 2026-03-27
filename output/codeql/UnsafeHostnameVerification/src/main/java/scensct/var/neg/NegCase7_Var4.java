// A class instance creation expression flows to a sink but the reference type used is not the constructed type should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.util.Optional;

public class NegCase7_Var4 {
    static class AlwaysTrueVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        // Variant 4: Wrap in Optional, but never unwrap to HostnameVerifier
        Optional<Object> opt = Optional.of(new AlwaysTrueVerifier());
        opt.ifPresent(o -> {
            // o is of type Object here, not HostnameVerifier
            System.out.println(o.toString());
        });
        // No security-sensitive call
    }
}