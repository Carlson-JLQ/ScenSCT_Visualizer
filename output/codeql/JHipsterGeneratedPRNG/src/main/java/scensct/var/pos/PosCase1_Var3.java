// RandomUtil.generate method returning String via RandomStringUtils non-random method should be flagged as weak RNG.
package scensct.var.pos;

import org.apache.commons.lang.RandomStringUtils;

public class PosCase1_Var3 {
    public static class RandomUtil {
        // Variant 3: Inter-procedural refactoring - extract the generation to a private helper
        public String generateAlphanumeric() {
            return generateString(10);
        }
        
        private String generateString(int len) { // [REPORTED LINE]
            return RandomStringUtils.randomAlphanumeric(len);
        }
    }
}