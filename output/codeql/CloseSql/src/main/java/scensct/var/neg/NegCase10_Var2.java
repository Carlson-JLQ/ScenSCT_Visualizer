// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.var.neg;

public class NegCase10_Var2 {
    // Variant 2: Use a factory method to create the instance
    static class NonCloseable {
        void doWork() {}
    }
    
    static class MyResource extends NonCloseable {}
    
    private MyResource createResource() {
        return new MyResource();
    }
    
    public void test() {
        MyResource res = createResource();
        // Should not trigger
    }
}