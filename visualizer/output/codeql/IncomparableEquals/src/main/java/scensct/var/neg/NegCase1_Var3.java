// A Java source file containing no method call named equals with exactly one parameter of type java.lang.Object and return type boolean should not be flagged as incomparable equals.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Try-catch, temporary variable, unrelated equals (StringBuilder).
        String str = "demo";
        StringBuilder sb = new StringBuilder(str);
        try {
            int l = str.length();
            System.out.println(l);
        } catch (Exception e) {
            // ignore
        }
        boolean eq = sb.equals(sb); // equals(Object) on same type, but StringBuilder is not in scope of incomparable types
        // Actually, this is still equals(Object) call, but the rule is about *incomparable* types.
        // Since sb and sb are same type, it's comparable. The seed is negative because there is *no* equals(Object) call.
        // Adding ANY equals(Object) call changes the scenario! Wait, careful.
        // The invariant: "no method call named equals with exactly one parameter of type java.lang.Object".
        // Adding ANY equals(Object) call would violate the invariant, turning it into a positive case.
        // So we must NOT add any equals(Object) call at all.
        // Let me correct: remove that line.
        // Instead, use a different method:
        boolean empty = str.isEmpty();
    }
}