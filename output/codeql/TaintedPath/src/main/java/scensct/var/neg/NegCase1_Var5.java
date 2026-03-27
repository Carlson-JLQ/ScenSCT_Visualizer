// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;

public class NegCase1_Var5 {
    private static String getConfigPath() {
        return "static/config.txt";
    }

    public static void main(String[] args) {
        // Variant 5: inter‑procedural – helper method returning literal
        File file = new File(getConfigPath());
        System.out.println(file.exists());
    }
}