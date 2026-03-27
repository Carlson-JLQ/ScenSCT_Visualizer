// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: intra‑procedural – trivial conditional, same constant both sides
        String config;
        if (System.currentTimeMillis() > 0) {
            config = "static/config.txt";
        } else {
            config = "static/config.txt"; // same literal
        }
        File file = new File(config);
        System.out.println(file.exists());
    }
}