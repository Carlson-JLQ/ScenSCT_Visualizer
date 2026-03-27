// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class without any debug-containing expression along the path should be flagged as positive.
package scensct.core.pos;

import android.webkit.WebView;

public class PosCase1 {
    public void enableDebugging() {
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(true); // Direct true literal, no debug guard // [REPORTED LINE]
    }
}