// A Java class overrides android.webkit.WebViewClient.onReceivedSslError and invokes android.webkit.SslErrorHandler.proceed on a variable that is not the second parameter should not be flagged as unconditionally accepting SSL certificates.
package scensct.var.neg;

import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.http.SslError;

public class NegCase3_Var1 extends WebViewClient {
    @Override
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        SslErrorHandler localHandler = null;
        // Use a while loop to obscure the null check
        while (localHandler != null) {
            localHandler.proceed(); // Call on local variable, not parameter
            break;
        }
        // Parameter 'handler' remains unused for proceed
    }
}