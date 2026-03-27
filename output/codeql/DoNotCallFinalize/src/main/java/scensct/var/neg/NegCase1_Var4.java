// Calling a method other than zero-parameter finalize should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase1_Var4 {
    public void someMethod() {
        Runnable r = () -> {
            System.out.println("test");
            Integer.parseInt("123");
            hashCode();
        };
        r.run();
        // Reflection call to finalize – not a direct prohibited call
        try {
            getClass().getMethod("finalize").invoke(this);
        } catch (Exception e) {}
    }
    // This method is unrelated to Object.finalize (has a parameter)
    public void finalize(String msg) {
        System.out.println(msg);
    }
}