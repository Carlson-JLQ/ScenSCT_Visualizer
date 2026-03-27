// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase10_Var5 {
    // Variant 5: Guard variable computed, sink moved to a helper method with guard passed
    private static void enableDebugIfTest(WebView wv, boolean debugTest) {
        if (debugTest) {
            wv.setWebContentsDebuggingEnabled(true);
        }
    }

    public static void main(String[] args) {
        boolean debug = true;
        boolean test = true;
        boolean isDebugTest = debug && test; // Combines "debug" and "test"
        WebView webView = new WebView(null);
        enableDebugIfTest(webView, isDebugTest);
    }
}