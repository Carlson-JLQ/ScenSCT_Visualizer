// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase8 {
    public static void main(String[] args) {
        boolean flag = true; // Source: true literal flows to variable 'flag'.
        WebView webView = new WebView(null);
        // The sink argument is an expression involving 'flag', but the literal node is not directly the argument.
        webView.setWebContentsDebuggingEnabled(flag && true); // SNK is the expression node, not the literal node.
    }
}