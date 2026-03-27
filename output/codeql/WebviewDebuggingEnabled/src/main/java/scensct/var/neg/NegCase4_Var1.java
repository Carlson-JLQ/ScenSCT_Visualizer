// Data flows from a non-literal boolean source to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use Boolean.valueOf to create a non-literal Boolean, then unbox.
        Boolean flagObj = Boolean.valueOf(true);
        boolean flag = flagObj.booleanValue();
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(flag);
    }
}