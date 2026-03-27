// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on the second parameter, but conditionally guarded should not be flagged as unconditionally accepting SSL certificates.
package scensct.core.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase5 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // Conditional guard: proceed is not called on all paths.
        if (error != null && error.getPrimaryError() == android.net.http.SslError.SSL_DATE_INVALID) {
            handler.proceed(); // Only called under a condition, not unconditional.
        } else {
            handler.cancel(); // Different path without proceed.
        }
        // Since proceed is conditional, it should not trigger the checker.
    }
}