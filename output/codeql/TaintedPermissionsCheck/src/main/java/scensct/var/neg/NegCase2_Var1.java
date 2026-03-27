// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Source remains, but no permission sink.
        AnotherClass src = new AnotherClass();
        String data = src.toString();
        // Lexical change: using a different output method.
        java.io.PrintStream out = System.out;
        out.println(data);
    }
}