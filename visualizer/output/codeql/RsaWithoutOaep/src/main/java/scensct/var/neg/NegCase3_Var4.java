// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase3_Var4 {
    public static void main(String[] args) throws Exception {
        // Variant 4: Algorithm from a wrapper object with delayed initialization
        AlgorithmHolder holder = new AlgorithmHolder();
        String alg = holder.getAlgorithm();
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    static class AlgorithmHolder {
        private final String algorithm;
        
        AlgorithmHolder() {
            this.algorithm = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
        }
        
        String getAlgorithm() {
            return algorithm;
        }
    }
}