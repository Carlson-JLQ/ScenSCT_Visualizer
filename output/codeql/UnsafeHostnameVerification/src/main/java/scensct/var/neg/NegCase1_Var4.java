// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1_Var4 {
    // Variant 4: Verifier returned from a method but ignored
    static HostnameVerifier getAlwaysTrueVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
    }

    public static void main(String[] args) {
        getAlwaysTrueVerifier(); // result ignored, no sink
        // Dummy loop that doesn't use a sink
        for (int i = 0; i < 10; i++) {
            HostnameVerifier local = getAlwaysTrueVerifier();
            // local not used in a sink
        }
    }
}