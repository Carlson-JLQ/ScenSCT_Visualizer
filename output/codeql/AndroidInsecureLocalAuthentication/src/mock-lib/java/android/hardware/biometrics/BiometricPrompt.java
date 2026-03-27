package android.hardware.biometrics;

public class BiometricPrompt {
    public static class AuthenticationCallback {
        public void onAuthenticationSucceeded(AuthenticationResult result) {}
    }
    public static class AuthenticationResult {
        public Object getDescription() { return null; }
    }
}