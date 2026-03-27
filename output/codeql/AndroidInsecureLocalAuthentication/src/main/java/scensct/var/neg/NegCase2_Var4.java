// A class (not extending any of the specified Android callback classes) that declares a method named onAuthenticationSucceeded should not be flagged.
package scensct.var.neg;

public class NegCase2_Var4 {
    // Change method to static? No, keep instance method but add a dummy parameter.
    // Actually, keep signature exactly, but add a dummy local variable and a conditional.
    public void onAuthenticationSucceeded(android.hardware.biometrics.BiometricPrompt.AuthenticationResult result) {
        boolean flag = Math.random() > 0.5;
        if (flag) {
            System.out.println(result.getDescription());
        } else {
            System.out.println("No result shown");
        }
    }
}