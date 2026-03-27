// A true boolean literal flows to the sink argument but guarded by a debug-test conditional should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase10_Var1 {
    public static void main(String[] args) {
        // Variant 1: Guard variable renamed, but still contains "debug" and "test"
        boolean debugTestMode = true;
        WebView wv = new WebView(null);
        if (debugTestMode) {
            wv.setWebContentsDebuggingEnabled(Boolean.TRUE); // Using Boolean.TRUE constant
        }
    }
}