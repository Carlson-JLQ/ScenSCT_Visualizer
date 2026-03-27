// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed, but the qualifier is not a simple variable access should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase4_Var1 extends WebViewClient {
    private SslErrorHandler mHandler; // Renamed field.

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        mHandler = handler; // Direct field assignment without 'this'.
        mHandler.proceed(); // Proceed via field.
    }
}