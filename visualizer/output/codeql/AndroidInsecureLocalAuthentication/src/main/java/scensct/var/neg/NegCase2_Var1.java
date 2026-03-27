// A class (not extending any of the specified Android callback classes) that declares a method named onAuthenticationSucceeded should not be flagged.
package scensct.var.neg;

public class NegCase2_Var1 {
    // Renamed class, but still does not extend Android callback classes.
    // Method signature preserved.
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        // Store parameter in a local variable before use.
        var authResult = result;
        if (authResult != null) {
            System.out.println("Auth succeeded: " + authResult.getDescription());
        }
    }
}