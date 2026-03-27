// A HostnameVerifier that always returns true flows through non-mitigating methods and a non-security guard to a sink should be flagged as unsafe.
package scensct.var.pos;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class PosCase4_Var5 {
    // Unsafe verifier with a redundant field
    static class BadVerifier implements HostnameVerifier {
        private final boolean acceptAll = true;
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return acceptAll;
        }
    }

    // Chain of methods (inter-procedural flow)
    static BadVerifier makeVerifier() {
        return new BadVerifier();
    }
    static HostnameVerifier wrapVerifier(BadVerifier bv) {
        return (HostnameVerifier) bv;
    }
    static HostnameVerifier getVerifierChain() {
        return wrapVerifier(makeVerifier());
    }

    // Guard using a ternary operator
    static void setVerifier(HostnameVerifier verifier) {
        boolean useHttps = true;
        HostnameVerifier target = useHttps ? verifier : null;
        if (target != null) {
            HttpsURLConnection.setDefaultHostnameVerifier(target); // [REPORTED LINE]
        }
    }

    public static void main(String[] args) {
        setVerifier(getVerifierChain());
    }
}