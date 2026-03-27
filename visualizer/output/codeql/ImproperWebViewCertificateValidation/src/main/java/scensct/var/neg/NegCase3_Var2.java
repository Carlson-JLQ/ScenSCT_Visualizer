// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on a variable that is not the second parameter should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase3_Var2 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        SslErrorHandler temp = getNullHandler();
        if (temp == null) {
            // Do nothing
        } else {
            temp.proceed(); // Proceed on a different handler instance
        }
        // Parameter 'handler' is ignored
    }

    private SslErrorHandler getNullHandler() {
        return null;
    }
}