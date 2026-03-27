// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debug-containing expression lacking test along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase2_Var3 {
    public void enableDebugging() {
        WebView webView = new WebView(null);
        if (System.currentTimeMillis() > 0) { // always true
            webView.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
        }
    }
}