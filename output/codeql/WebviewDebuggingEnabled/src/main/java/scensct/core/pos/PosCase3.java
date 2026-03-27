// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not being a variable access along the path should be flagged as positive.
package scensct.core.pos;

import android.webkit.WebView;

public class PosCase3 {
    public void enableDebugging() {
        String debugtest = "debugtest";
        WebView webView = new WebView(null);
        // debugtest is a variable but not used as guard; method call uses literal true
        webView.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
    }
}