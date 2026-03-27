// equals method passing parameter to abstract method should not be flagged as missing type test
package scensct.var.neg;

public class NegCase6_Var4 {
    @Override
    public boolean equals(Object obj) {
        // Pass through a static native method
        NegCase6_Var4Helper.check(obj);
        return false;
    }
    
    private static class NegCase6_Var4Helper {
        static native void check(Object o);
    }
}