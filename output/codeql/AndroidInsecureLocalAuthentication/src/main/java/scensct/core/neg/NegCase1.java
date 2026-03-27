// A Java class containing any method that is not named onAuthenticationSucceeded should not be flagged as not using authentication result for cryptographic operations.
package scensct.core.neg;

public class NegCase1 {
    // This method is not named onAuthenticationSucceeded, so it should not be flagged.
    public void someOtherMethod(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        // Method body does not use result for crypto, but that's irrelevant for this scenario.
        System.out.println("Not the callback method.");
    }
}