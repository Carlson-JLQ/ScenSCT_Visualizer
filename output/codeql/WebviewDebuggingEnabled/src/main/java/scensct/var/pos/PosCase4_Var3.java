// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase4_Var3 {
    private void enableDebug(WebView wv) {
        wv.setWebContentsDebuggingEnabled(true); // extracted method // [REPORTED LINE]
    }

    public void enableDebugging() {
        boolean debugtest = false;
        WebView webView = new WebView(null);
        enableDebug(webView); // call passes true literal via constant param
    }
}