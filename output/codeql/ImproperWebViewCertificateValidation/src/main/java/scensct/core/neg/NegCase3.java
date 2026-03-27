// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on a variable that is not the second parameter should not be flagged as unconditionally accepting SSL certificates.
package scensct.core.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase3 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        SslErrorHandler anotherHandler = null; // Different variable than the parameter.
        if (anotherHandler != null) {
            anotherHandler.proceed(); // Proceed called on a variable other than the parameter 'handler'.
        }
        // The parameter 'handler' is not used to call proceed, so should not trigger.
    }
}