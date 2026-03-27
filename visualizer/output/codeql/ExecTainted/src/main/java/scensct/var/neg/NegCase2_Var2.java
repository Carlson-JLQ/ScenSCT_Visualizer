// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;

public class NegCase2_Var2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("safe_constant");
        sb.append("_string");
        String constantInput = sb.toString();
        
        Runtime.getRuntime().exec("echo " + constantInput);
    }
}