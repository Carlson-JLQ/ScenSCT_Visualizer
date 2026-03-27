// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase2_Var5 {
    // Inter-procedural: move the true literal to a static initializer, but still not connected to sink
    private static final boolean DEBUG_FLAG = true;
    
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        // Use a local variable that shadows the static field, but assign false
        boolean debugFlag = false;
        webView.setWebContentsDebuggingEnabled(debugFlag); // Sink with different argument.
    }
}