// A false boolean literal flows to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase5_Var3 {
    // Variant 3: Control flow that always picks false branch.
    public static void main(String[] args) {
        WebView w = new WebView(null);
        boolean enable;
        if (args.length < 0) { // always false at runtime
            enable = true;
        } else {
            enable = false;
        }
        w.setWebContentsDebuggingEnabled(enable); // [REPORTED LINE]
    }
}