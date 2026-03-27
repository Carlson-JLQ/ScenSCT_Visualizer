// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase7 {
    public static void helper(boolean b) {
        // Method call with true literal argument, but not the target sink.
    }
    public static void main(String[] args) {
        helper(true); // True literal flows to non-sink method.
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(false);
    }
}