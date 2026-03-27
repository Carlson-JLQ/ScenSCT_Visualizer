// A class extending one of the specified Android callback classes that overrides onAuthenticationSucceeded with the correct parameter type, accesses the parameter inside the method body, but does NOT call super.onAuthenticationSucceeded with that parameter as the argument should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 extends android.hardware.biometrics.BiometricPrompt.AuthenticationCallback {
    @Override
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        // Variant 2: Intra-procedural restructuring - conditional branch that always accesses parameter.
        if (result != null) {
            System.out.println("Success: " + result.getDescription());
        } else {
            // Dead branch, but preserves access pattern.
            throw new IllegalStateException("Result should not be null");
        }
    }
}