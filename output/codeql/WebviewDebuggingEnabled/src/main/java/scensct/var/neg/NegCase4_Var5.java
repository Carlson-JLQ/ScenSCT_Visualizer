// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        // Variant 5: Loop and temporary variable obscuring the flow.
        boolean flag = false;
        for (int i = 0; i < 1; i++) {
            flag = Boolean.TRUE; // non-literal assignment inside loop
        }
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(flag);
    }
}