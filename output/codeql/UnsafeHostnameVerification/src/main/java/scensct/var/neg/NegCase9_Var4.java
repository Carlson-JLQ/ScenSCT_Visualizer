// A HostnameVerifier that always returns true is set as default inside a block guarded by a flag with name indicating insecure configuration should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class NegCase9_Var4 {
    // Variant 4: Inline verifier as a static field initialized via helper method, use switch-like if-else chain
    private static HostnameVerifier createVerifier() {
        String flag = System.getProperty("disableHostnameVerification");
        if (flag == null) {
            return HttpsURLConnection.getDefaultHostnameVerifier();
        } else if (flag.equals("true")) {
            return (hostname, session) -> true;
        } else {
            return HttpsURLConnection.getDefaultHostnameVerifier();
        }
    }

    public static void main(String[] args) throws Exception {
        String flag = System.getProperty("disableHostnameVerification");
        if ("true".equals(flag)) {
            // Only set when flag is true, but verifier already encapsulates the condition
            HostnameVerifier verifier = createVerifier();
            HttpsURLConnection.setDefaultHostnameVerifier(verifier); // [REPORTED LINE]
        }
    }
}