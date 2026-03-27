// User input flows to a different sink, not reaching regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // Use StringBuilder for concatenation
        StringBuilder builder = new StringBuilder("Prefix ");
        builder.append(input);
        String output = builder.toString();
        // Fixed regex pattern
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("^Prefix.*");
        System.out.println(p.matcher(output).matches());
    }
}