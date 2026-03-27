// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase2_Var4 {
    public static void main(String[] args) {
        // Split instantiation and assignment.
        AnotherClass userInput;
        userInput = new AnotherClass();
        // Chain method calls without introducing sink.
        System.out.println(userInput.toString());
    }
}