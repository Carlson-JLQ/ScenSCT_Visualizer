// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not controlling the basic block along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase4_Var1 {
    public void enableDebugging() {
        // Rename variable, reorder statements, use final constant
        final boolean isDebug = false;
        WebView wv = new WebView(null);
        final boolean enableFlag = true;
        wv.setWebContentsDebuggingEnabled(enableFlag); // still literal true // [REPORTED LINE]
    }
}