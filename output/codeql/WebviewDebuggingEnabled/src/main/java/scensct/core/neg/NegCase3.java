// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase3 {
    public static void main(String[] args) {
        boolean flag = true; // Source: true literal.
        WebView webView = new WebView(null);
        // The literal 'true' is not used as the argument to the sink.
        webView.setWebContentsDebuggingEnabled(flag == true); // Argument is an expression, not direct flow from literal.
    }
}