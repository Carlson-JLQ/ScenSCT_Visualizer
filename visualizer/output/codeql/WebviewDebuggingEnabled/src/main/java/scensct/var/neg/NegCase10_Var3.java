// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase10_Var3 {
    // Variant 3: Guard via a final field, control flow with early return
    private static final boolean DEBUG_TEST = true;

    public static void main(String[] args) {
        if (!DEBUG_TEST) {
            return; // Early exit if not debug-test
        }
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(true); // Now reachable only when guard true
    }
}