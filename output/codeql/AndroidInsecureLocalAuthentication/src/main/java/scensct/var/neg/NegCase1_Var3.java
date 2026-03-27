// A Java class containing any method that is not named onAuthenticationSucceeded should not be flagged as not using authentication result for cryptographic operations.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Introduce a helper class to hold the method.
    static class AuthHandler {
        void onAuth(android.hardware.biometrics.BiometricPrompt.AuthenticationResult r) {
            // Non-crypto: just assign to local variable.
            var unused = r;
        }
    }

    public void trigger() {
        new AuthHandler().onAuth(null);
    }
}