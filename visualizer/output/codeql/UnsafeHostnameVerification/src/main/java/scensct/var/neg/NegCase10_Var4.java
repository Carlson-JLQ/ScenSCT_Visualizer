// A HostnameVerifier that always returns true is set as default without a security flag guard but flow passes through a method with name indicating insecure SSL handling should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase10_Var4 {
    // Variant 4: Method reference to a method that returns true, wrapped in try-catch
    static boolean alwaysAccept(String host, SSLSession session) {
        return true;
    }

    static void disableVerification() {
        HostnameVerifier verifier = NegCase10_Var4::alwaysAccept;
        try {
            HttpsURLConnection.setDefaultHostnameVerifier(verifier);
        } catch (SecurityException e) {
            // ignore
        }
    }

    public static void main(String[] args) {
        disableVerification();
    }
}