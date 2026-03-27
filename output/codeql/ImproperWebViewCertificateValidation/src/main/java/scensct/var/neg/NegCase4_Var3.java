// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed, but the qualifier is not a simple variable access should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase4_Var3 extends WebViewClient {
    private SslErrorHandler fieldHandler;

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        assignHandler(handler); // Extract assignment to helper method.
        invokeProceed(); // Extract proceed call to helper method.
    }

    private void assignHandler(SslErrorHandler h) {
        this.fieldHandler = h;
    }

    private void invokeProceed() {
        this.fieldHandler.proceed(); // Still field access.
    }
}