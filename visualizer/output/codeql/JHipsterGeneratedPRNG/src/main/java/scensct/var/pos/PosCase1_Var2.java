// RandomUtil.generate method returning String via RandomStringUtils non-random method should be flagged as weak RNG.
package scensct.var.pos;

import org.apache.commons.lang.RandomStringUtils;

public class PosCase1_Var2 {
    public static class RandomUtil {
        // Variant 2: Intra-procedural refactoring - wrap call in a conditional that always executes
        public String generateAlphanumeric() {
            boolean shouldGenerate = true;
            if (shouldGenerate) {
                return RandomStringUtils.randomAlphanumeric(10);
            }
            return ""; // dead code, but preserves signature
        }
    }
}