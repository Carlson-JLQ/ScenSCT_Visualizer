// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: lexical – constant built via concatenation of literals
        String path = "static/" + "config.txt";
        File file = new File(path);
        System.out.println(file.exists());
    }
}