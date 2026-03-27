// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debug-containing expression lacking test along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase2_Var4 {
    private void setDebug(WebView wv, boolean flag) {
        wv.setWebContentsDebuggingEnabled(flag); // [REPORTED LINE]
    }
    
    public void enableDebugging() {
        String debugMode = "debug";
        WebView webView = new WebView(null);
        setDebug(webView, true);
    }
}