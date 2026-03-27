// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.var.neg;

public class NegCase10_Var1 {
    // Variant 1: Introduce an intermediate abstract class with methods, still no close
    static abstract class AbstractResource {
        abstract void use();
        void prepare() {}
    }
    
    static class NonCloseable extends AbstractResource {
        void use() {}
    }
    
    static class MyResource extends NonCloseable {
        // No close method
    }
    
    public void test() {
        MyResource res = new MyResource();
        // Should not trigger
    }
}