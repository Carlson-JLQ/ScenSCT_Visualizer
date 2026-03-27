// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Idiomatic variation - read multiple lines, but only output the first, with loop.
        Scanner scanner = new Scanner(System.in);
        String firstInput = null;
        for (int i = 0; i < 3 && scanner.hasNextLine(); i++) {
            String line = scanner.nextLine();
            if (i == 0) {
                firstInput = line;
            }
        }
        if (firstInput != null) {
            System.out.println("First user entry: " + firstInput); // Non-regex sink.
        }
    }
}