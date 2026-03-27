// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase8_Var1 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        // Reorder operands and use parentheses to change expression structure
        webView.setWebContentsDebuggingEnabled(true && flag);
    }
}