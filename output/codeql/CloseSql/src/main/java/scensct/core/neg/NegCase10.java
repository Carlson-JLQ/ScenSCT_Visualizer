// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.core.neg;

public class NegCase10 {
    // Type with ancestor methods but no "close" method
    static class NonCloseable {
        void someMethod() {}
    }
    
    static class MyResource extends NonCloseable {
        // No close method declared or inherited
    }
    
    public void test() {
        // CloseableInitExpr of type that is not closeable
        MyResource res = new MyResource();
        // Should not trigger SQL resource checker
    }
}