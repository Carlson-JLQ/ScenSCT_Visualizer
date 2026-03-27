// A true boolean literal exists but the source node is an indirect variable, not the literal itself, should not be flagged.
package scensct.ref.neg;

import android.webkit.WebView;

public class NegCase6_FP1 {
    public static void main(String[] args) {
        boolean flag = true; // True literal assigns to variable.
        boolean anotherFlag = flag; // Source node is variable 'anotherFlag', not the literal.
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(anotherFlag); // Sink with variable source. // [REPORTED LINE]
    }
}