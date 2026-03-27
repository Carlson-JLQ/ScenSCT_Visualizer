// A false boolean literal flows to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase5_Var1 {
    // Variant 1: Use a static final constant that is false.
    private static final boolean DEBUG_MODE = false;

    public static void main(String[] args) {
        WebView wv = new WebView(null);
        wv.setWebContentsDebuggingEnabled(DEBUG_MODE);
    }
}