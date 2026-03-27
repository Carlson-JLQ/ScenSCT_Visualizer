// A user-controlled source exists but no data flow sink node for permissions construction should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        AnotherClass userInput = new AnotherClass();
        // Use StringBuilder for processing, but still no permission sink.
        StringBuilder sb = new StringBuilder();
        sb.append(userInput.toString());
        String result = sb.reverse().toString(); // Some transformation.
        System.out.println(result);
    }
}