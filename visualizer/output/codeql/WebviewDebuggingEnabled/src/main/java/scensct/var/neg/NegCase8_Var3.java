// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase8_Var3 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        // Use a ternary operator that always evaluates to the same expression
        webView.setWebContentsDebuggingEnabled((flag ? true : false) && true);
    }
}