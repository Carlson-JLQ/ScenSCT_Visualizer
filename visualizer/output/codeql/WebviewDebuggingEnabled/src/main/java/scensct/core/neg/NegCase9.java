// A true boolean literal flows to the sink argument inside a non-security test class should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase9 {
    // This class is not a security test class (e.g., not annotated or named as such).
    private static boolean getTrue() {
        return true;
    }
    
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(getTrue()); // Flow occurs in non-security test class. // [REPORTED LINE]
    }
}