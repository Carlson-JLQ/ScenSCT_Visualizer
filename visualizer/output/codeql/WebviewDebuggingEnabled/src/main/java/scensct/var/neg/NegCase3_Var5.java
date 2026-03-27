// A true boolean literal and the sink are on the same path but no flow from literal to sink argument should not be flagged.
package scensct.var.neg;

import android.webkit.WebView;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        boolean flag = true;
        WebView webView = new WebView(null);
        boolean param;
        try {
            param = flag == true; // Expression in try block
        } catch (Exception e) {
            param = false; // Never happens
        }
        webView.setWebContentsDebuggingEnabled(param);
    }
}