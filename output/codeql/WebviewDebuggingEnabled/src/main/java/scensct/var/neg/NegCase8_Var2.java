// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase8_Var2 {
    public static void main(String[] args) {
        final boolean source = true;
        boolean flag = source;
        WebView webView = new WebView(null);
        // Introduce a temporary variable for the expression
        boolean arg = flag && true;
        webView.setWebContentsDebuggingEnabled(arg);
    }
}