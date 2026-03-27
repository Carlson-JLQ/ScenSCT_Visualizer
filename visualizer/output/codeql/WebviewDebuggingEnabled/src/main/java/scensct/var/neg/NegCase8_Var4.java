// A true boolean literal flows to a node SNK, but SNK is not the sink argument node should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase8_Var4 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        // Extract the argument computation to a private static helper method
        webView.setWebContentsDebuggingEnabled(computeArg(flag));
    }

    private static boolean computeArg(boolean f) {
        return f && true;
    }
}