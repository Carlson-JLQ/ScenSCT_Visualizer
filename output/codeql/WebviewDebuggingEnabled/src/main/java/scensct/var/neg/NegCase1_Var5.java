// A program with no true boolean literal should not be flagged as having a true literal flow to WebView.setWebContentsDebuggingEnabled.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        WebView webView = null;
        try {
            webView = new WebView(null);
            for (int i = 0; i < 1; i++) {
                // loop does nothing to the flag
            }
        } catch (Exception e) {
            // ignore
        } finally {
            if (webView != null) {
                webView.setWebContentsDebuggingEnabled(false);
            }
        }
    }
}