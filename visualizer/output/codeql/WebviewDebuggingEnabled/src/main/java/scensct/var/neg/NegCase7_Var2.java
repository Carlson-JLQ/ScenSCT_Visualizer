// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase7_Var2 {
    // Variant 2: Intra-procedural refactoring - introduce temporary and conditional that does not affect sink.
    public static void logDebug(boolean b) {
        // Non-sink.
    }
    public static void main(String[] args) {
        boolean flag = true;
        if (flag) {
            logDebug(flag);
        }
        WebView wv = null;
        wv = new WebView(null);
        boolean sinkArg = false;
        // Ensure sink call is reachable.
        wv.setWebContentsDebuggingEnabled(sinkArg);
    }
}