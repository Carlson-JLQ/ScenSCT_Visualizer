// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase2_Var2 {
    // Inter-procedural refactoring: extract sink call to a helper method
    private static void setDebugging(WebView wv, boolean enabled) {
        wv.setWebContentsDebuggingEnabled(enabled);
    }
    
    public static void main(String[] args) {
        boolean flag = true; // Source: true literal, but not flowing to sink.
        WebView webView = new WebView(null);
        // Pass false directly, not using flag
        setDebugging(webView, false); // Sink with different argument.
    }
}