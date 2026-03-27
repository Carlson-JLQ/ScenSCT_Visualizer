// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Lexical refactoring: split declaration and assignment, use final
        final boolean flag;
        flag = true; // Source: true literal, but not flowing to sink.
        
        WebView webView = new WebView(null);
        // Control-flow restructuring: wrap sink in a trivial if-else that always takes the false branch
        if (System.currentTimeMillis() > 0) {
            // This branch always executes, but the condition is not a guard on the literal
            webView.setWebContentsDebuggingEnabled(false); // Sink with different argument.
        } else {
            // Dead branch, never reached
            webView.setWebContentsDebuggingEnabled(flag); // [REPORTED LINE]
        }
    }
}