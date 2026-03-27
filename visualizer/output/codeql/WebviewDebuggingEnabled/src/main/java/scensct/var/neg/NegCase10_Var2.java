// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase10_Var2 {
    // Variant 2: Guard extracted to a method returning debug-test boolean
    private static boolean isInDebugTest() {
        return true;
    }

    public static void main(String[] args) {
        WebView webView = new WebView(null);
        if (isInDebugTest()) {
            webView.setWebContentsDebuggingEnabled(1 == 1); // Equivalent true expression
        }
    }
}