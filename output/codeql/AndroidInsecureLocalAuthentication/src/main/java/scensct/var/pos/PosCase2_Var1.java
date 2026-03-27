// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.var.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2_Var1 extends BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        // Introduce a temporary variable that does not change the usage
        BiometricPrompt.AuthenticationResult res = result;
        super.onAuthenticationSucceeded(res);
    }
}