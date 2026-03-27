// RandomUtil.generate method returning String via RandomStringUtils non-random method should be flagged as weak RNG.
package scensct.var.pos;

import org.apache.commons.lang.RandomStringUtils;

public class PosCase1_Var5 {
    public static class RandomUtil {
        // Variant 5: Complex intra-procedural - try-catch block that returns the generated string
        public String generateAlphanumeric() {
            try {
                return RandomStringUtils.randomAlphanumeric(10);
            } catch (Exception e) {
                throw new RuntimeException("Generation failed", e);
            }
        }
    }
}