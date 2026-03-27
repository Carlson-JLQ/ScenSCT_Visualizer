// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase4 {
    public static void main(String[] args) {
        boolean flag = Boolean.TRUE; // Source: not a boolean literal.
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(flag); // Sink with non-literal source.
    }
}