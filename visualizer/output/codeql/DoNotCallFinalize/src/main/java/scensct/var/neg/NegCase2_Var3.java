// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var3 {
    @Override
    protected void finalize() throws Throwable {
        invokeSuperFinalize();
    }

    private void invokeSuperFinalize() throws Throwable {
        super.finalize(); // [REPORTED LINE]
    }
}