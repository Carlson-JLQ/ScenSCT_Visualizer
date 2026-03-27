// A Java class that does not override android.webkit.WebViewClient.onReceivedSslError should not be flagged as unconditionally accepting SSL certificates.
package scensct.core.neg;

import android.webkit.WebViewClient;

public class NegCase1 extends WebViewClient {
    // This class extends WebViewClient but does NOT override onReceivedSslError.
    // Therefore, it should not trigger the checker.
}