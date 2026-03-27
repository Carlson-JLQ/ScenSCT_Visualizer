// A class extends android.webkit.WebViewClient and overrides onReceivedSslError, directly calling handler.proceed() without any conditional checks should be flagged as unconditional SSL error acceptance.
package scensct.core.pos;

import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PosCase1 extends WebViewClient {
    @Override
    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) { // [REPORTED LINE]
        // Direct call to proceed without any conditional validation
        handler.proceed();
    }
}