// User input flows to a different sink, not reaching regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase4_Var3 {
    private static String addPrefix(String s) {
        return "Prefix " + s;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String result = addPrefix(userInput);
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^Prefix.*");
        System.out.println(pattern.matcher(result).matches());
    }
}