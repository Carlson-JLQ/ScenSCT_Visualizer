// Unbraced else branch with same-column successor and less indented if statement should be flagged as positive.
package scensct.core.pos;

public class PosCase4 {
    public static void main(String[] args) {
        boolean condition = false;
        if (condition)
            System.out.println("Then branch");
        else
            System.out.println("Else branch"); // Unbraced else branch, not another if
System.out.println("Misleading successor"); // Same column as else keyword, if statement less indented
    }
}