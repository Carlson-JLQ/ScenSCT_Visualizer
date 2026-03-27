// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase7_Var5 {
    // Variant 5: Control-flow restructuring - loop that passes true to non-sink, sink after loop.
    public static void process(boolean b) {
        // Non-sink.
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            process(true);
        }
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(false);
    }
}