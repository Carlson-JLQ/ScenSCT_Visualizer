// Calling a method other than zero-parameter finalize should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase1_Var3 {
    public void someMethod() {
        doWork();
        try {
            // empty
        } finally {
            // super.finalize() allowed because we are not in overriding finalize()
            try { super.finalize(); } catch (Throwable t) {} // [REPORTED LINE]
        }
    }
    private void doWork() {
        System.out.println("test");
        Integer.parseInt("123");
        this.hashCode();
    }
    // This is not Object.finalize (return type differs)
    public String finalize(Object obj) {
        return obj.toString();
    }
}