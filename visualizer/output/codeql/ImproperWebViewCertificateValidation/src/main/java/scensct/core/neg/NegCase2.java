// A Java class overrides android.webkit.WebViewClient.onReceivedSslError but does not invoke android.webkit.SslErrorHandler.proceed should not be flagged as unconditionally accepting SSL certificates.
package scensct.core.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase2 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // Overrides the method but does NOT call handler.proceed().
        // This should not trigger the checker.
        super.onReceivedSslError(view, handler, error); // Optional, but shows no proceed call.
    }
}