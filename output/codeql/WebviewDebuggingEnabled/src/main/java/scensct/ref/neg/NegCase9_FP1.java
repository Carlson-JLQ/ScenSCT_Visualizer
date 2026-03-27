// A true boolean literal flows to the sink argument inside a non-security test class should not be flagged.
package scensct.ref.neg;

import android.webkit.WebView;

public class NegCase9_FP1 {
    // This class is not a security test class (e.g., not annotated or named as such).
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(true); // Flow occurs in non-security test class. // [REPORTED LINE]
    }
}