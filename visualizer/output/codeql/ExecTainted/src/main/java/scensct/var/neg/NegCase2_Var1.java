// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase2_Var1 {
    public static void main(String[] args) throws IOException {
        final String part1 = "safe_";
        String part2 = "constant";
        String part3 = "_string";
        String constantInput = part1 + part2 + part3;
        
        Runtime.getRuntime().exec("echo " + constantInput);
    }
}