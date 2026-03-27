// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.var.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2_Var2 extends BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) { // [REPORTED LINE]
        // Wrap the super call in a trivial if block that always executes
        if (true) {
            super.onAuthenticationSucceeded(result);
        }
    }
}