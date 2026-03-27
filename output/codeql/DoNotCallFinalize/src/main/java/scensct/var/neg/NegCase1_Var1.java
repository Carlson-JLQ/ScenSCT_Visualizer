// Calling a method other than zero-parameter finalize should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase1_Var1 {
    public void cleanup() {
        java.io.PrintStream out = System.out;
        out.println("test");
        Integer.valueOf("123");
        this.hashCode();
        // This is a different method (has a parameter) – not the zero-arg finalize
        finalize(42);
        // super.finalize() call is allowed outside an overriding finalize()
        try {
            super.finalize(); // [REPORTED LINE]
        } catch (Throwable t) {}
    }
    private void finalize(int x) {
        System.out.println("Not the Object.finalize");
    }
}