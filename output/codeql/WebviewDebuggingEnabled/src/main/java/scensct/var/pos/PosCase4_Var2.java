// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase4_Var2 {
    public void enableDebugging() {
        boolean debugtest = false;
        // Introduce a trivial if(true) block
        if (true) {
            WebView webView = new WebView(null);
            webView.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
        }
        // debugtest still irrelevant
    }
}