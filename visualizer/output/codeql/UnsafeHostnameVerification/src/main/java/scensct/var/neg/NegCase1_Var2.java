// A HostnameVerifier that always returns true but is never used in a hostname verification sink should not be flagged as insecure.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class NegCase1_Var2 {
    // Variant 2: Anonymous class with extra method, created conditionally
    static HostnameVerifier createVerifier(boolean flag) {
        if (flag) {
            return new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
        }
        return null;
    }

    public static void main(String[] args) {
        HostnameVerifier v = createVerifier(args.length == 0);
        // v may be null, but even if not, no sink usage
    }
}