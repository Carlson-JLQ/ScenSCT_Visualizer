// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase4_Var4 {
    // Variant 4: Non-literal from a final field (still not a literal in the call).
    private static final Boolean DEBUG_FLAG = Boolean.TRUE;

    public static void main(String[] args) {
        WebView webView = new WebView(null);
        boolean flag = DEBUG_FLAG;
        webView.setWebContentsDebuggingEnabled(flag);
    }
}