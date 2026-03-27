// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.var.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1_Var2 extends FingerprintManager.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) { // [REPORTED LINE]
        // Control-flow restructuring: if-else that never uses result.
        boolean success = true;
        if (success) {
            logSuccess();
        } else {
            // Dead branch, still no result usage.
            System.out.println("Unexpected");
        }
    }

    private void logSuccess() {
        System.out.println("Authentication succeeded.");
    }
}