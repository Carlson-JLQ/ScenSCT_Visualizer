// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase10 {
    public static void main(String[] args) {
        boolean isDebugTest = true; // Variable name contains "debug" and "test".
        WebView webView = new WebView(null);
        if (isDebugTest) { // Guard with debug-test variable.
            webView.setWebContentsDebuggingEnabled(true); // Guarded flow.
        }
    }
}