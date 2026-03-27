// A Java class that does not override android.webkit.WebViewClient.onReceivedSslError should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.WebViewClient;

public class NegCase1_Var5 extends WebViewClient {
    // Add a method with a similar signature but different name and behavior.
    public void onReceivedError(android.webkit.WebView view, int errorCode,
                                String description, String failingUrl) {
        // Not the target method.
    }
    
    // Use a static factory method to create instance.
    public static NegCase1_Var5 create() {
        return new NegCase1_Var5();
    }
    
    // Absence of onReceivedSslError remains.
}