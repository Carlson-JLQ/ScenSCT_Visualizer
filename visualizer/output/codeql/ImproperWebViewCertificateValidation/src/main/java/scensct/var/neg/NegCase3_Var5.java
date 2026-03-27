// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on a variable that is not the second parameter should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase3_Var5 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // Introduce a helper method that conditionally calls proceed on a local variable
        handleSslLocally();
        // Parameter 'handler' remains unused
    }

    private void handleSslLocally() {
        SslErrorHandler local = null;
        if (local != null) {
            local.proceed(); // Not the parameter
        }
    }
}