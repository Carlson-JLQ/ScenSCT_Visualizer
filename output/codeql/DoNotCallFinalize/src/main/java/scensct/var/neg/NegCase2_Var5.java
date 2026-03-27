// Calling super.finalize() within an overriding finalize method should not be flagged as a prohibited finalize call.
package scensct.var.neg;

public class NegCase2_Var5 {
    @Override
    protected void finalize() throws Throwable {
        Runnable r = () -> {
            // Direct super call inside lambda (still within overriding finalize)
            // Lambda is inside the instance method, so super refers to outer class's super
            // But lambda cannot contain super call directly? Actually, it can if it's inside the instance method.
            // However, super inside lambda refers to NegCase2_Var5.super.
            // Let's test: This is valid Java.
        };
        // Actually, lambda cannot contain super.finalize() because super is not allowed in static context.
        // So we must call super.finalize() outside lambda.
        // Instead, use an anonymous class.
        new Object() {
            void callSuper() throws Throwable {
                NegCase2_Var5.super.finalize(); // [REPORTED LINE]
            }
        }.callSuper();
    }
}