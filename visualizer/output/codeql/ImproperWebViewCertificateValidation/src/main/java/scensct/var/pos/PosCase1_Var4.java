// A class extends android.webkit.WebViewClient and overrides onReceivedSslError, directly calling handler.proceed() without any conditional checks should be flagged as unconditional SSL error acceptance.
package scensct.var.pos;

import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PosCase1_Var4 extends WebViewClient {
    @Override
    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
        // Added dead code that does not affect the unconditional call
        int unused = 42;
        if (unused > 0) {
            // This always executes
            handler.proceed();
        }
        // No else branch, so call is still unconditional
    }
}