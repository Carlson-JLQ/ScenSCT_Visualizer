// A method call that is not printStackTrace, and there exists a PrintWriter-on-StringWriter configuration where an exception's stack trace is printed to it, but the StringWriter is not converted to a string via toString() should not be flagged.
package scensct.var.neg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NegCase8_Var4 {
    public static void main(String[] args) {
        // Variant 4: Multiple StringWriter/PrintWriter pairs, only one used for stack trace
        StringWriter sw1 = new StringWriter();
        StringWriter sw2 = new StringWriter();
        PrintWriter pw1 = new PrintWriter(sw1);
        PrintWriter pw2 = new PrintWriter(sw2);
        Exception e = new RuntimeException("test");
        e.printStackTrace(pw1); // Only pw1 gets stack trace
        pw1.flush();
        pw2.flush();
        // Neither sw1 nor sw2 turned to string
        System.out.println("Done");
    }
}