// A false boolean literal flows to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase5_Var5 {
    // Variant 5: Ternary expression with constant false outcome.
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        boolean debug = (System.currentTimeMillis() > 0) ? false : true;
        // The condition is always true, so debug is always false.
        webView.setWebContentsDebuggingEnabled(debug); // [REPORTED LINE]
    }
}