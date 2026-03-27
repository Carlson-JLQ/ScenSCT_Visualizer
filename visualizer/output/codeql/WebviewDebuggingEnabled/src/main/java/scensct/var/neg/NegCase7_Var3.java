// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase7_Var3 {
    // Variant 3: Inter-procedural refactoring - extract sink call to a helper that takes false.
    public static void setupWebView(WebView wv, boolean debug) {
        wv.setWebContentsDebuggingEnabled(debug);
    }
    public static void dummy(boolean b) {
        // Non-sink.
    }
    public static void main(String[] args) {
        dummy(true);
        WebView webView = new WebView(null);
        setupWebView(webView, false);
    }
}