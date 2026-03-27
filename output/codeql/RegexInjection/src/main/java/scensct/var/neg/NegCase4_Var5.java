// User input flows to a different sink, not reaching regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase4_Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String prefix = "Prefix ";
        String result = "";
        for (int i = 0; i < 1; i++) { // executes once
            result = prefix + userInput;
        }
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^Prefix.*");
        System.out.println(pattern.matcher(result).matches());
    }
}