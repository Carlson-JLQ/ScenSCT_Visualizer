// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.core.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2 extends BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) { // [REPORTED LINE]
        // Parameter 'result' is accessed only to pass to super call, no other use.
        super.onAuthenticationSucceeded(result);
    }
}