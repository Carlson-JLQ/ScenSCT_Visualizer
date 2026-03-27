// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.core.pos;

import java.security.SecureRandom;

public class PosCase5 {
    public static void main(String[] args) {
        // Scenario 5: Constructor with predictable seed, additional setSeed, used for random data
        SecureRandom sr = new SecureRandom();
        sr.setSeed(33333L); // Predictable seed
        sr.setSeed(44444L); // Additional predictable seed
        int firstRandom = sr.nextInt(); // First random data operation // [REPORTED LINE]
        
        // Other random data operations allowed after prior operation
        int secondRandom = sr.nextInt(); // Operation after prior operation // [REPORTED LINE]
    }
}