// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on the second parameter, but conditionally guarded should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase5_Var4 extends WebViewClient {
    // Variant 4: Extract condition to a private helper method
    private boolean shouldProceed(SslError error) {
        return error != null && error.getPrimaryError() == SslError.SSL_DATE_INVALID;
    }

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        if (shouldProceed(error)) {
            handler.proceed();
        } else {
            handler.cancel();
        }
    }
}