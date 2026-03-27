// A user-controlled value flows to an expression and the permissions construction is a method call not for permissions check should not be flagged.
package scensct.var.neg;

import com.exp.AnotherClass;

public class NegCase6_Var1 {
    // Simulating a non-permission-check method.
    static void logPermission(String perm) {}

    public static void main(String[] args) {
        // Variant 1: Lexical refactoring - rename locals, split assignment, use different source method.
        AnotherClass src = new AnotherClass();
        String data = src.toString();
        String permissionString = data;
        logPermission(permissionString);
    }
}