// A CloseableInitExpr whose type has ancestor types that declare methods, but none named "close", should not be flagged as unclosed.
package scensct.var.neg;

public class NegCase10_Var4 {
    // Variant 4: Use a generic container to hold the resource, type unchanged
    static class NonCloseable {
        void methodA() {}
    }
    
    static class MyResource extends NonCloseable {}
    
    static class Holder<T> {
        T obj;
        Holder(T obj) { this.obj = obj; }
    }
    
    public void test() {
        Holder<MyResource> holder = new Holder<>(new MyResource());
        // The actual MyResource instance is inside holder.obj
        // Still no close method in hierarchy
    }
}