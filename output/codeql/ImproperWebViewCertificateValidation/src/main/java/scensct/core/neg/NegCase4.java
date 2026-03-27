// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed, but the qualifier is not a simple variable access should not be flagged as unconditionally accepting SSL certificates.
package scensct.core.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase4 extends WebViewClient {
    private SslErrorHandler fieldHandler; // Field, not a simple parameter variable.

    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        this.fieldHandler = handler; // Assign parameter to field.
        this.fieldHandler.proceed(); // Proceed called via field access, not simple variable 'handler'.
        // The checker likely expects simple variable access to the parameter, so this should not trigger.
    }
}