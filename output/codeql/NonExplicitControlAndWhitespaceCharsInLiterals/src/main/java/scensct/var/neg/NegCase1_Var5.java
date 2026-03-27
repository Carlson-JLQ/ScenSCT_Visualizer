// Printable ASCII and normal whitespace in string/numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Using streams and lambdas to embed literals
        String whitespace = Stream.of(' ', '\t', '\n', '\r', '\f')
            .map(String::valueOf)
            .collect(Collectors.joining());
        String text = "Hello, World! 123";
        int number = Integer.parseInt("42"); // numeric literal inside string
        int hex = Integer.decode("0x2A");
        int binary = Integer.parseInt("101010", 2);
        String escaped = Stream.of("Tab:\t", "Newline:\n", "Return:\r", "Formfeed:\f")
            .collect(Collectors.joining());
        System.out.println(text + whitespace + number + hex + binary + escaped);
    }
}