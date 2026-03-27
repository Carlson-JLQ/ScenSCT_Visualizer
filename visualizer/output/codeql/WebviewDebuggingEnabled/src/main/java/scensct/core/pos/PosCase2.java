// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debug-containing expression lacking test along the path should be flagged as positive.
package scensct.core.pos;

import android.webkit.WebView;

public class PosCase2 {
    public void enableDebugging() {
        String debugMode = "debug";
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(true); // True literal, debug expression present but no test // [REPORTED LINE]
    }
}