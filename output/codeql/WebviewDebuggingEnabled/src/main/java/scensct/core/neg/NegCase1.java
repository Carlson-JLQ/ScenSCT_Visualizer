// A program with no true boolean literal should not be flagged as having a true literal flow to WebView.setWebContentsDebuggingEnabled.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase1 {
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        // No true boolean literal exists in the program.
        webView.setWebContentsDebuggingEnabled(false);
    }
}