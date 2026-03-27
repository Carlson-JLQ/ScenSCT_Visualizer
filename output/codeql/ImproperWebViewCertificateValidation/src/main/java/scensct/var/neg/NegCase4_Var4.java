// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed, but the qualifier is not a simple variable access should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase4_Var4 extends WebViewClient {
    private SslErrorHandler fieldHandler;

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        this.fieldHandler = handler;
        if (view != null) { // Add irrelevant conditional that doesn't affect field access.
            this.fieldHandler.proceed();
        } else {
            this.fieldHandler.proceed(); // Same call in both branches.
        }
    }
}