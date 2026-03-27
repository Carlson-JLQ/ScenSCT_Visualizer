// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        // Variant 2: Non-literal from a simple conditional expression.
        boolean flag = (args != null) ? Boolean.TRUE : false;
        WebView webView = new WebView(null);
        if (webView != null) {
            webView.setWebContentsDebuggingEnabled(flag);
        }
    }
}