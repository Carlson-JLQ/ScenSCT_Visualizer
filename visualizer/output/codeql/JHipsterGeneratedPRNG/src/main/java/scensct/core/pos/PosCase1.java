// RandomUtil.generate method returning String via RandomStringUtils non-random method should be flagged as weak RNG.
package scensct.core.pos;

import org.apache.commons.lang.RandomStringUtils;

public class PosCase1 {
    public static class RandomUtil {
        public String generateAlphanumeric() { // [REPORTED LINE]
            return RandomStringUtils.randomAlphanumeric(10); // Single return calling non-random method
        }
    }
}