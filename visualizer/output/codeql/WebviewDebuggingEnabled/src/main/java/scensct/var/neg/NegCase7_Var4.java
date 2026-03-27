// A true boolean literal flows to a method argument, but the method is not the sink should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase7_Var4 {
    // Variant 4: Idiomatic variation - use Boolean object for true, but primitive false for sink.
    public static void accept(Boolean b) {
        // Non-sink, auto-unboxing.
    }
    public static void main(String[] args) {
        accept(Boolean.TRUE);
        WebView webView = new WebView(null);
        webView.setWebContentsDebuggingEnabled(Boolean.FALSE.booleanValue());
    }
}