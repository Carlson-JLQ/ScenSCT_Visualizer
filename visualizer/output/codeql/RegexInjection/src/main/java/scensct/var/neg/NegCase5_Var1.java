// Sanitized user input before regex compilation should not be flagged as regex injection.
package scensct.var.neg;

import java.util.Scanner;
import java.util.regex.Pattern;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String raw = scanner.nextLine();
        // Use static import style (Pattern.quote) and rename
        String safePattern = Pattern.quote(raw);
        Pattern compiled = Pattern.compile(safePattern);
        System.out.println(compiled.matcher(raw).matches());
    }
}