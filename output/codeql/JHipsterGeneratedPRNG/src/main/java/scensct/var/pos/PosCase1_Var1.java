// RandomUtil.generate method returning String via RandomStringUtils non-random method should be flagged as weak RNG.
package scensct.var.pos;

import org.apache.commons.lang.RandomStringUtils;

public class PosCase1_Var1 {
    public static class RandomUtil {
        // Variant 1: Lexical refactoring - rename method and add intermediate variable
        public String createSecureToken() {
            int length = 10;
            String token = RandomStringUtils.randomAlphanumeric(length);
            return token;
        }
    }
}