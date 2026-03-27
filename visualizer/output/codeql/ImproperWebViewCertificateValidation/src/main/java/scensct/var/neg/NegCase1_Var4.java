// A Java class that does not override android.webkit.WebViewClient.onReceivedSslError should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.WebViewClient;

public class NegCase1_Var4 extends WebViewClient {
    // Introduce an inner class that itself extends WebViewClient but still no onReceivedSslError.
    public static class InnerClient extends WebViewClient {
        // Inner also lacks the override.
    }
    
    private InnerClient inner = new InnerClient();
    
    // Main class still does not override onReceivedSslError.
}