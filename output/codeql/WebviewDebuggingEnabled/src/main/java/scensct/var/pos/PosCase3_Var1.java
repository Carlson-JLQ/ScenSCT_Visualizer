// A true literal flows to WebView.setWebContentsDebuggingEnabled inside a non-test class with debugtest variable not being a variable access along the path should be flagged as positive.
package scensct.var.pos;

import android.webkit.WebView;

public class PosCase3_Var1 {
    public void enableDebugging() {
        WebView webView = new WebView(null);
        boolean flag = true;
        webView.setWebContentsDebuggingEnabled(flag); // [REPORTED LINE]
    }
}