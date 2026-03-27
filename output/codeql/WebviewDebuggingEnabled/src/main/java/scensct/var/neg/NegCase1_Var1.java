// A program with no true boolean literal should not be flagged as having a true literal flow to WebView.setWebContentsDebuggingEnabled.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase1_Var1 {
    private static final boolean DEBUG_FLAG = false;
    
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        boolean enableDebug = DEBUG_FLAG;
        webView.setWebContentsDebuggingEnabled(enableDebug);
    }
}