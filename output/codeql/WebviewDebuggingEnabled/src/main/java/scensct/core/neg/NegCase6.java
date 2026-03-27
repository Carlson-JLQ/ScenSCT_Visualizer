// A true boolean literal exists but the source node is an indirect variable, not the literal itself, should not be flagged.
package scensct.core.neg;

import android.webkit.WebView;

public class NegCase6 {
    private static boolean getTrue() {
        return true;
    }
    
    public static void main(String[] args) {
        boolean flag = getTrue(); // True literal assigns to variable via method.
        boolean anotherFlag = flag; // Source node is variable 'anotherFlag', not the literal.
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(anotherFlag); // Sink with variable source. // [REPORTED LINE]
    }
}