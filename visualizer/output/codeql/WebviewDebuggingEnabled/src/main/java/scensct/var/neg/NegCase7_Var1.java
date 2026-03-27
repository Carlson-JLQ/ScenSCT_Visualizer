// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase7_Var1 {
    // Variant 1: Lexical refactoring - rename helper, use explicit variable for true, and invert false via variable.
    public static void forwardDebugFlag(boolean debug) {
        // Non-sink method.
    }
    public static void main(String[] args) {
        boolean enableDebug = true;
        forwardDebugFlag(enableDebug);
        WebView webView = new WebView(null);
        boolean disableDebug = false;
        webView.setWebContentsDebuggingEnabled(disableDebug);
    }
}