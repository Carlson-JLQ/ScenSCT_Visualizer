// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on a variable that is not the second parameter should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase3_Var3 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        SslErrorHandler alias = null;
        SslErrorHandler target = alias;
        // Try-catch to add control-flow complexity
        try {
            if (target != null) {
                target.proceed(); // Not the parameter
            }
        } catch (Exception e) {
            // Ignore
        }
        // Parameter 'handler' not involved
    }
}