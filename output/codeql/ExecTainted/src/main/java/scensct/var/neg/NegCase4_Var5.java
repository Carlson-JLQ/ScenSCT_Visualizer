// A recognized threat model source and a command injection sink exist in the same program, but there is no taint flow path connecting the source to the sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase4_Var5 {
    public static void main(String[] args) throws IOException {
        String userInput = args[0];
        String safePart1 = getConstantPrefix();
        String safePart2 = getConstantSuffix();
        String safeCommand = combine(safePart1, safePart2);
        
        Runtime.getRuntime().exec(safeCommand);
        
        // userInput only used in a different object
        StringBuilder unrelated = new StringBuilder();
        unrelated.append(userInput);
    }
    
    private static String getConstantPrefix() { return "echo"; }
    private static String getConstantSuffix() { return " hello"; }
    private static String combine(String a, String b) { return a + b; }
}