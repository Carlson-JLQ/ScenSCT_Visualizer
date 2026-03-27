// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.var.neg;

public class NegCase10_Var3 {
    // Variant 3: Wrap initialization in a try-catch, still no close
    static class NonCloseable {
        void operation() {}
    }
    
    static class MyResource extends NonCloseable {}
    
    public void test() {
        try {
            MyResource res = new MyResource();
            // res used but never closed (no close method exists)
        } catch (Exception e) {
            // ignore
        }
    }
}