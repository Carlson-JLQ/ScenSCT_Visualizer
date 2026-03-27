// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debug-containing expression lacking test along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase2_Var2 {
    public void enableDebugging() {
        String mode = "debug";
        WebView wv = new WebView(null);
        boolean enable = true;
        wv.setWebContentsDebuggingEnabled(enable); // [REPORTED LINE]
    }
}