// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;

public class NegCase1_Var2 {
    private static final String BASE = "static";
    private static final String EXT = ".txt";

    public static void main(String[] args) {
        // Variant 2: inter‑procedural – constant from final static fields
        String fileName = "config";
        File file = new File(BASE + "/" + fileName + EXT);
        System.out.println(file.exists());
    }
}