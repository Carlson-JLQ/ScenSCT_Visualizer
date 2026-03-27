// A false boolean literal flows to the sink argument should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase5 {
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(false); // Sink with false literal.
    }
}