// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debug-containing expression lacking test along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase2_Var5 {
    public void enableDebugging() {
        String debugMode = "debug";
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(Boolean.TRUE);
    }
}