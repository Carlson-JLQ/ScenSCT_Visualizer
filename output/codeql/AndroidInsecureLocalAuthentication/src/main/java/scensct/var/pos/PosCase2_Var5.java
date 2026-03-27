// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.var.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2_Var5 extends BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
        // Add a redundant local variable and a no-op statement
        BiometricPrompt.AuthenticationResult authResult = result;
        int dummy = 0; // unrelated to result
        super.onAuthenticationSucceeded(authResult);
    }
}