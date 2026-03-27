// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase3_Var3 {
    // Variant 3: Inter-procedural refactoring - extract regex compilation to a helper method, passing only constant.
    public static void compileAndTest(String regex) {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        System.out.println(pattern.matcher("test").matches());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String unusedInput = scanner.nextLine(); // Isolated source.
        compileAndTest("\\w+");
    }
}