// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.var.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1_Var1 extends FingerprintManager.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authResult) { // [REPORTED LINE]
        // Renamed parameter, still unused.
        String message = "Authentication succeeded.";
        System.out.println(message);
        // Added local variable but no use of authResult.
    }
}