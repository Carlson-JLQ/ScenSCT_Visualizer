// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase4_Var3 {
    // Variant 3: Extract non-literal source to a static method.
    private static boolean getDebugFlag() {
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(getDebugFlag());
    }
}