// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.core.pos;

import android.webkit.WebView;

public class PosCase4 {
    public void enableDebugging() {
        boolean debugtest = false;
        WebView webView = new WebView(null);
        // debugtest variable exists but does not guard the call
        webView.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
    }
}