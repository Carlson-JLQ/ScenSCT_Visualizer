// A class extends android.webkit.WebViewClient and overrides onReceivedSslError, directly calling handler.proceed() without any conditional checks should be flagged as unconditional SSL error acceptance.
package scensct.var.pos;

import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PosCase1_Var3 extends WebViewClient {
    @Override
    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
        // Extracted the call to a private helper method that still unconditionally proceeds
        handleSslError(handler);
    }

    private void handleSslError(SslErrorHandler handler) {
        handler.proceed();
    }
}