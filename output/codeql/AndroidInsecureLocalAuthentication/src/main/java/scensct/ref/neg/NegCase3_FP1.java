// A class extending one of the specified Android callback classes that declares a method named onAuthenticationSucceeded with zero parameters should not be flagged.
package scensct.ref.neg;

public class NegCase3_FP1 extends android.hardware.biometrics.BiometricPrompt.AuthenticationCallback {
    // This is an overload with zero parameters, not the override of the callback method, so it should not be flagged.
    public void onAuthenticationSucceeded() { // [REPORTED LINE]
        System.out.println("Overload without parameter.");
    }
}