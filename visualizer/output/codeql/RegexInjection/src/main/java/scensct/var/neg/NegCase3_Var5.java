// Isolated user input with no flow to regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase3_Var5 {
    // Variant 5: Complex control flow with try-catch, still no data flow from input to regex.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userData = sc.nextLine();
        String regex = null;
        try {
            regex = "\\w+";
            // Simulate some operation that doesn't involve userData.
            int dummy = userData.length(); // This uses userData but not in regex.
            if (dummy > 1000) {
                throw new RuntimeException("unlikely");
            }
        } catch (Exception e) {
            regex = "\\d*";
        } finally {
            // regex is still a constant, independent of userData.
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
            System.out.println(p.matcher("data").matches());
        }
    }
}