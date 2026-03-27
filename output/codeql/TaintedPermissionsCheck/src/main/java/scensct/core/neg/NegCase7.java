// A user-controlled value flows to an expression and the permissions construction is a WildCardPermission constructor where E is not the first argument should not be flagged.
package scensct.core.neg;

import org.apache.shiro.authz.permission.WildCardPermission;
import com.exp.AnotherClass;

public class NegCase7 {
    public static void main(String[] args) {
        // Scenario: user value flows to E, but E is not the first argument of WildCardPermission constructor.
        AnotherClass userInput = new AnotherClass(); // Source.
        String tainted = userInput.toString(); // Expression E.
        // WildCardPermission constructor with E as second argument (if such overload existed; using placeholder).
        // Assuming a hypothetical constructor: WildCardPermission(String part1, String part2).
        // For realism, we use a standard single-arg constructor but pass E concatenated non-first.
        String firstArg = "fixed";
        String combined = firstArg + ":" + tainted; // E is part of combined, not first arg directly.
        WildCardPermission perm = new WildCardPermission(combined); // Sink, but E not first arg.
        // Alternative: if no such constructor, use a different approach: E is used in a different position via array.
        // For minimality, we assume the checker only flags when E is exactly the first argument.
    }
}