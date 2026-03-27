// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on the second parameter, but conditionally guarded should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase5_Var5 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        // Variant 5: Try-catch with same logic (catch block does not affect guard)
        try {
            if (error != null && error.getPrimaryError() == SslError.SSL_DATE_INVALID) {
                handler.proceed();
            } else {
                handler.cancel();
            }
        } catch (RuntimeException e) {
            // Fallback cancel on unexpected runtime issue
            handler.cancel();
        }
    }
}