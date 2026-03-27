// A program with no true boolean literal should not be flagged as having a true literal flow to WebView.setWebContentsDebuggingEnabled.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase1_Var2 {
    public static void main(String[] args) {
        WebView webView = new WebView(null);
        boolean flag;
        if (args.length > 1000) { // impossible in practice
            flag = true;
        } else {
            flag = false;
        }
        webView.setWebContentsDebuggingEnabled(flag); // [REPORTED LINE]
    }
}