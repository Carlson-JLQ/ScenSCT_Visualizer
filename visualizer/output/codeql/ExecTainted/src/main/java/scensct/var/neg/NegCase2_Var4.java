// A taint flow path exists from a source that is not a recognized threat model source to a command injection sink should not be flagged as command injection.
package scensct.var.neg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var4 {
    public static void main(String[] args) throws IOException {
        String constantInput = "safe_constant_string";
        List<String> command = new ArrayList<>();
        command.add("echo");
        command.add(constantInput);
        
        new ProcessBuilder(command).start();
    }
}