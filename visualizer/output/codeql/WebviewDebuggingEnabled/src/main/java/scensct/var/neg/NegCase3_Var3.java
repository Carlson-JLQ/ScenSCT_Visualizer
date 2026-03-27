// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(computeArg(flag));
    }

    private static boolean computeArg(boolean b) {
        return b == true; // Literal appears here, but result is expression
    }
}