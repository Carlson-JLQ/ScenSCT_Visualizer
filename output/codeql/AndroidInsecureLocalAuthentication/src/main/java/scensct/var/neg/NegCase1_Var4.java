// A Java class containing any method that is not named onAuthenticationSucceeded should not be flagged as not using authentication result for cryptographic operations.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Method with try-catch and control flow.
    public void verifyResult(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        try {
            if (result != null) {
                // Access a getter but not for crypto.
                int id = result.hashCode();
                System.out.println(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}