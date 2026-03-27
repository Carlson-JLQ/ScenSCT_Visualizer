// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase10_Var4 {
    // Variant 4: Guard variable aliased via another variable, sink inside try block
    public static void main(String[] args) {
        boolean isDebugTest = true;
        boolean condition = isDebugTest; // Alias
        WebView webView = new WebView(null);
        try {
            if (condition) {
                webView.setWebContentsDebuggingEnabled(true);
            }
        } finally {
            // No-op, just to add control-flow complexity
        }
    }
}