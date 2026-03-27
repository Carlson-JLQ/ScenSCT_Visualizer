// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.var.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1_Var3 extends FingerprintManager.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        // Introduce a temporary variable that shadows but does not use result.
        Object ignored = result;
        // Still no cryptographic operation or actual usage.
        System.out.println("Authentication succeeded.");
        // The 'ignored' variable is never read.
    }
}