package android.hardware.fingerprint;

public class FingerprintManager {
    public static class AuthenticationCallback {
        public void onAuthenticationSucceeded(AuthenticationResult result) {}
    }
    public static class AuthenticationResult {}
}