// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var6 {
    @Override
    protected void finalize() throws Throwable {
        // Delegate via an anonymous inner class
        new Object() {
            void invokeSuperFinalize() throws Throwable {
                NegCase2_Var6.super.finalize(); // [REPORTED LINE]
            }
        }.invokeSuperFinalize();
    }
}