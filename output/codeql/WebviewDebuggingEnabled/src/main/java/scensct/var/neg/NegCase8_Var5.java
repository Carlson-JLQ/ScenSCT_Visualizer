// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase8_Var5 {
    public static void main(String[] args) {
        boolean flag = Boolean.TRUE; // Boolean.TRUE is a constant, not a literal, but still true
        WebView webView = new WebView(null);
        // Use Boolean.logicalAnd to combine values
        webView.setWebContentsDebuggingEnabled(Boolean.logicalAnd(flag, true));
    }
}