// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        Boolean flagObj = Boolean.valueOf(true); // Literal inside valueOf
        WebView webView = new WebView(null);
        boolean arg = flagObj.equals(Boolean.TRUE); // Expression, not direct flow
        webView.setWebContentsDebuggingEnabled(arg);
    }
}