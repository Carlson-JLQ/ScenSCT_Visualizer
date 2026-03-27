// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase3_Var4 {
    // Variant 4: Idiomatic variation - use BufferedReader for input, and static Pattern compilation.
    public static void main(String[] args) throws Exception {
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String input = reader.readLine(); // Isolated.
        Pattern pattern = Pattern.compile("[a-zA-Z]+"); // Different constant pattern, still no flow.
        System.out.println(pattern.matcher("hello").find());
    }
}