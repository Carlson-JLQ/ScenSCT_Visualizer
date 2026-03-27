// A class extends android.webkit.WebViewClient and overrides onReceivedSslError, directly calling handler.proceed() without any conditional checks should be flagged as unconditional SSL error acceptance.
package scensct.var.pos;

import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PosCase1_Var1 extends WebViewClient {
    @Override
    public void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslHandler, SslError sslError) {
        // Renamed parameters and added a temporary variable
        SslErrorHandler h = sslHandler;
        h.proceed();
    }
}