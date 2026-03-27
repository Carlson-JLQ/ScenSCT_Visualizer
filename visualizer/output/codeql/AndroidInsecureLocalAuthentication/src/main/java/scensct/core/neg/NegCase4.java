// A class extending one of the specified Android callback classes that overrides onAuthenticationSucceeded with the correct parameter type, accesses the parameter inside the method body, but does NOT call super.onAuthenticationSucceeded with that parameter as the argument should not be flagged.
package scensct.core.neg;

public class NegCase4 extends android.hardware.biometrics.BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        // Parameter is accessed (e.g., for logging), but not used for cryptographic operations.
        // The scenario specifies not calling super, which is satisfied here.
        System.out.println("Authentication succeeded: " + result.getDescription());
    }
}