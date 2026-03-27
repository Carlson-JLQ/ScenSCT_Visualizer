// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.var.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2_Var4 extends BiometricPrompt.AuthenticationCallback {
    // Extract a private helper method that only passes the parameter
    private void callSuper(BiometricPrompt.AuthenticationResult r) {
        super.onAuthenticationSucceeded(r);
    }

    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        callSuper(result);
    }
}