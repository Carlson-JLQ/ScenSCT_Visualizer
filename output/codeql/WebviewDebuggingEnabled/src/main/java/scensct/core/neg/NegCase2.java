// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase2 {
    public static void main(String[] args) {
        boolean flag = true; // Source: true literal, but not flowing to sink.
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(false); // Sink with different argument.
    }
}