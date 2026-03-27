// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read multiple lines but only use first
        String line = scanner.nextLine();
        // Use a StringBuilder to construct the pattern (still sanitized)
        StringBuilder sb = new StringBuilder();
        sb.append(Pattern.quote(line));
        Pattern pattern = Pattern.compile(sb.toString());
        // Also add flags (case-insensitive) but still safe
        Pattern patternWithFlags = Pattern.compile(sb.toString(), Pattern.CASE_INSENSITIVE);
        System.out.println(patternWithFlags.matcher(line).matches());
    }
}