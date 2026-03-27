// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.var.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1_Var5 extends FingerprintManager.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) { // [REPORTED LINE]
        // Try-catch-finally block without using result.
        try {
            System.out.println("Authentication succeeded.");
        } catch (Exception e) {
            // Ignore
        } finally {
            // Cleanup that doesn't touch result.
            int x = 0;
        }
    }
}