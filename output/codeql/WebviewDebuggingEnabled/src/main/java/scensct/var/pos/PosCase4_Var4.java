// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase4_Var4 {
    public void enableDebugging() {
        boolean debugtest = false;
        WebView webView = new WebView(null);
        // Use Boolean.TRUE which is a constant true
        webView.setWebContentsDebuggingEnabled(Boolean.TRUE);
    }
}