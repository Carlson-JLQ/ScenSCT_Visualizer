// A method declared in a class whose simple name is not "RandomUtil" should not be flagged as using weak random string generation.
package scensct.core.neg;

public class NegCase1 {
    // Class name is not RandomUtil, so any method inside should not trigger the checker.
    public static String generateRandomAlphanumeric(int count) {
        return "dummy"; // Not a RandomStringUtils call, and class name mismatch ensures negative.
    }
}