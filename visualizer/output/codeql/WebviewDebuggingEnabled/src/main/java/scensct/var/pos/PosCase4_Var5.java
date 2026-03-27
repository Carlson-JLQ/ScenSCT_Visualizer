// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase4_Var5 {
    public void enableDebugging() {
        boolean debugtest = false;
        WebView webView = null;
        try {
            webView = new WebView(null);
        } finally {
            // Call inside finally block, still unguarded
            webView.setWebContentsDebuggingEnabled(true); // [REPORTED LINE]
        }
    }
}