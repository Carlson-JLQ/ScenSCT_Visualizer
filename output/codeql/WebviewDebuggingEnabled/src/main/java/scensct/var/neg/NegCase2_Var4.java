// A true boolean literal exists but not on the same data flow path as the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Control-flow restructuring: loop that never executes, containing the true literal flow
        for (int i = 0; i < 0; i++) {
            // This block is dead code, so the true literal inside does not flow to sink
            boolean flag = true;
            WebView w = new WebView(null);
            w.setWebContentsDebuggingEnabled(flag);
            return;
        }
        // Actual flow: true literal exists but is isolated
        boolean otherFlag = true;
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(false); // Sink with different argument.
    }
}