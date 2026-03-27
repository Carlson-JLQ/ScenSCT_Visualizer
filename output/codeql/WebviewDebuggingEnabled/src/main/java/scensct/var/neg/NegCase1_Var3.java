// A program with no true boolean literal should not be flagged as having a true literal flow to WebView.setWebContentsDebuggingEnabled.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase1_Var3 {
    private static void configureWebViewDebug(WebView wv, boolean debug) {
        wv.setWebContentsDebuggingEnabled(debug);
    }
    
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        configureWebViewDebug(webView, false);
    }
}