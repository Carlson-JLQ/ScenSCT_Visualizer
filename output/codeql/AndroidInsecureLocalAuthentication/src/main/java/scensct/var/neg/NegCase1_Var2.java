// A Java class containing any method that is not named onAuthenticationSucceeded should not be flagged as not using authentication result for cryptographic operations.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Method with extra parameters and different return type.
    public boolean processAuthentication(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result,
                                        String context) {
        if (result == null) {
            return false;
        }
        // Still no crypto usage.
        System.out.println(context);
        return true;
    }
}