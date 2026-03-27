// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        final boolean source = Boolean.TRUE; // Still a true literal constant
        WebView webView = new WebView(null);
        // Use a ternary that always evaluates to true, but the literal is not the direct argument
        boolean arg = (source == Boolean.TRUE) ? true : false;
        webView.setWebContentsDebuggingEnabled(arg); // [REPORTED LINE]
    }
}