// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.var.neg;

public class NegCase10_Var5 {
    // Variant 5: Split declaration and assignment across branches
    static class NonCloseable {
        void execute() {}
    }
    
    static class MyResource extends NonCloseable {}
    
    public void test(boolean flag) {
        MyResource res;
        if (flag) {
            res = new MyResource();
        } else {
            res = null;
        }
        // res may be null or a MyResource, but still not closeable
    }
}