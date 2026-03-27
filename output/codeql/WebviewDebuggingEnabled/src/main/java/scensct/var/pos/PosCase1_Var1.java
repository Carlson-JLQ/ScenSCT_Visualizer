// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class without any debug-containing expression along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase1_Var1 {
    public void enableDebugging() {
        boolean debugFlag = true;
        WebView wv = new WebView(null);
        wv.setWebContentsDebuggingEnabled(debugFlag); // [REPORTED LINE]
    }
}