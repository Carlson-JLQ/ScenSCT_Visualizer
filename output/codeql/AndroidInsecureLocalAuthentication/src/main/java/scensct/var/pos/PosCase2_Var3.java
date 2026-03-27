// A class extending android.hardware.biometrics.BiometricPrompt$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter accessed only to call super should be flagged as a violation.
package scensct.var.pos;

import android.hardware.biometrics.BiometricPrompt;

public class PosCase2_Var3 extends BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) { // [REPORTED LINE]
        // Use a try-finally block where super call is in try, but no actual exception handling
        try {
            super.onAuthenticationSucceeded(result);
        } finally {
            // Empty finally, no extra use of result
        }
    }
}