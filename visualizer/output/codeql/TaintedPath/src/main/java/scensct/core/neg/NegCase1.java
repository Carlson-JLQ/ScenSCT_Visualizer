// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.core.neg;

import java.io.File;

public class NegCase1 {
    public static void main(String[] args) {
        // Sink: path operation using only string literals (non-tainted source)
        File file = new File("static/config.txt");
        System.out.println(file.exists());
    }
}