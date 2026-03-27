// A method with outer if null check on a different field should not be flagged as double-checked locking on field f.
package scensct.var.neg;

public class NegCase4_Var4 {
    private Object f;
    private static class Container {
        private Object g;
        Object getG() { return g; }
    }
    private Container container = new Container();

    public void method() {
        // Loop runs exactly once, but adds control-flow complexity
        do {
            if (container.getG() == null) {
                synchronized (this) {
                    if (f == null) {
                        f = new Object();
                    }
                }
            }
        } while (false);
    }
}