// A class extends android.webkit.WebViewClient and overrides onReceivedSslError, directly calling handler.proceed() without any conditional checks should be flagged as unconditional SSL error acceptance.
package scensct.var.pos;

import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class PosCase1_Var5 extends WebViewClient {
    @Override
    public void onReceivedSslError(android.webkit.WebView view, SslErrorHandler handler, SslError error) {
        // Split the call across multiple statements with a temporary
        SslErrorHandler temp = handler;
        temp.proceed();
        // Added a redundant statement that does not change behavior
        temp.toString();
    }
}