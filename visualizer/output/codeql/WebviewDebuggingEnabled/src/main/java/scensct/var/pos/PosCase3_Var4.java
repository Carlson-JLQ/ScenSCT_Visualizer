// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not being a variable access along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase3_Var4 {
    private void setupDebug(WebView wv) {
        wv.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
    }
    
    public void enableDebugging() {
        String debugtest = "debugtest";
        WebView webView = new WebView(null);
        setupDebug(webView);
    }
}