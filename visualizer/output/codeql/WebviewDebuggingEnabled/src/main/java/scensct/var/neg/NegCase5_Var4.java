// A false boolean literal flows to the sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase5_Var4 {
    // Variant 4: Boolean.FALSE and a temporary variable.
    public static void main(String[] args) {
        WebView v = new WebView(null);
        Boolean b = Boolean.FALSE;
        v.setWebContentsDebuggingEnabled(b.booleanValue());
    }
}