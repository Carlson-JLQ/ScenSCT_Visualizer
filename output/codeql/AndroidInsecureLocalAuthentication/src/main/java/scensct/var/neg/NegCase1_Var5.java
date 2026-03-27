// A Java class containing any method that is not named onAuthenticationSucceeded should not be flagged as not using authentication result for cryptographic operations.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Interface-based indirection.
    interface Processor {
        void consume(android.hardware.biometrics.BiometricPrompt.AuthenticationResult a);
    }

    private final Processor processor = new Processor() {
        @Override
        public void consume(android.hardware.biometrics.BiometricPrompt.AuthenticationResult a) {
            // No crypto.
            Object o = a;
        }
    };

    public void start() {
        processor.consume(null);
    }
}