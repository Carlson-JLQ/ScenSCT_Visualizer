// A user-controlled value flows to an expression but the permissions construction is not a method/constructor call should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase4_Var1 {
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        String tainted = userInput.toString();
        Object notPermission;
        if (System.currentTimeMillis() % 2 == 0) {
            notPermission = tainted;
        } else {
            notPermission = tainted + "extra";
        }
    }
}