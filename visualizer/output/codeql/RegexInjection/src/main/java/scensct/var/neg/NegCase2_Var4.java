// User input flows to a non-regex sink should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Variant 4: Intra-procedural refactoring - use try-with-resources and temporary variables.
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append("User entered: ").append(line);
            System.out.println(sb.toString()); // Non-regex sink.
        }
    }
}