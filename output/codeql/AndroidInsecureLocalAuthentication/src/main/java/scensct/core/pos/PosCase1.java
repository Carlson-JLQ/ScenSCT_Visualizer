// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.core.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1 extends FingerprintManager.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) { // [REPORTED LINE]
        // Parameter 'result' is declared but never accessed or referenced.
        // No cryptographic operation or any use of 'result'.
        System.out.println("Authentication succeeded.");
    }
}