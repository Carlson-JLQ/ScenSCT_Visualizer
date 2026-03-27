// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Idiomatic variation: use ternary operator to assign flag, but still separate from sink
        boolean flag = args.length == 0 ? true : false; // Evaluates to true, but not flowing to sink.
        WebView webView = new WebView(null);
        // Intra-procedural: introduce a temporary variable for the sink argument
        boolean debugMode = false;
        webView.setWebContentsDebuggingEnabled(debugMode); // Sink with different argument.
    }
}