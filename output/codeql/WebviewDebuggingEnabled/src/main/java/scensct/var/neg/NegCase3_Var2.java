// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        boolean param;
        if (flag) {
            param = (flag == true); // Expression, not direct literal
        } else {
            param = false; // Unreachable
        }
        webView.setWebContentsDebuggingEnabled(param);
    }
}