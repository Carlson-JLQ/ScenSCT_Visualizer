// A class (not extending any of the specified Android callback classes) that declares a method named onAuthenticationSucceeded should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    // This class does not extend Android callback classes, so even with this method name, it should not be flagged.
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        // Parameter is accessed but not for crypto, but the class context makes it irrelevant.
        System.out.println(result.getDescription());
    }
}