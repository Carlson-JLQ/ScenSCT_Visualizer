// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase2_Var3 {
    private static String getConstant() {
        return "safe_constant_string";
    }
    
    public static void main(String[] args) throws IOException {
        String constantInput = getConstant();
        Runtime.getRuntime().exec("echo " + constantInput);
    }
}