// A false boolean literal flows to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase5_Var2 {
    // Variant 2: Introduce a trivial method that returns false.
    private static boolean shouldEnableDebug() {
        return false;
    }

    public static void main(String[] args) {
        WebView webView = new WebView(null);
        boolean flag = shouldEnableDebug();
        webView.setWebContentsDebuggingEnabled(flag);
    }
}