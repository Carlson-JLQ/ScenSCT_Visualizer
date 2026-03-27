// A class extending android.hardware.fingerprint.FingerprintManager$AuthenticationCallback overrides onAuthenticationSucceeded with the parameter declared but never accessed should be flagged as a violation.
package scensct.var.pos;

import android.hardware.fingerprint.FingerprintManager;

public class PosCase1_Var4 extends FingerprintManager.AuthenticationCallback {
    // Add an unrelated method to vary class structure.
    public void dummy() {
        System.out.println("Dummy");
    }

    @Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) { // [REPORTED LINE]
        // Loop that doesn't involve result.
        for (int i = 0; i < 1; i++) {
            System.out.println("Authentication succeeded.");
        }
        // Parameter result remains unused.
    }
}