// A class extending one of the specified Android callback classes that overrides onAuthenticationSucceeded with the correct parameter type, accesses the parameter inside the method body, but does NOT call super.onAuthenticationSucceeded with that parameter as the argument should not be flagged.
package scensct.var.neg;

public class NegCase4_Var3 extends android.hardware.biometrics.BiometricPrompt.AuthenticationCallback {
    // Variant 3: Inter-procedural refactoring - extract parameter access to a private helper method.
    private void logSuccess(android.hardware.biometrics.BiometricPrompt.AuthenticationResult res) {
        String msg = "Authentication succeeded with: " + res.getDescription();
        System.out.println(msg);
    }

    @Override
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        logSuccess(result);
    }
}