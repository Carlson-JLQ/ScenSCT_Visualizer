// A constructor calls a non-abstract, non-final instance method declared in a superclass, that method is overridden in a superclass, the overriding method reads a non-final superclass field, the field is written by exactly one callable (a constructor), and that writing constructor does not call the original superclass constructor should not be flagged as unsafe initialization.
package scensct.var.neg;

public class NegCase7_Var5 {
    protected StringBuilder buffer;
    
    public NegCase7_Var5() {
        overriddenMethod();
    }
    
    void overriddenMethod() {
        System.out.println("Original method");
    }
}

class SubClass7 extends NegCase7_Var5 {
    {
        // Instance initializer runs after super() but before constructor body
        // However, field write here would occur after super()? Actually, instance initializers execute after super() call but before the rest of the constructor body.
        // This preserves the order: super() (calls overriddenMethod) -> instance initializer (writes field) -> constructor body.
        // But the write is not in the constructor body itself; it's in an initializer.
        // The rule says "written by exactly one callable (a constructor)". An instance initializer is not a constructor, but it's invoked as part of constructor execution.
        // To be safe, keep write in constructor, but restructure.
    }
    
    public SubClass7() {
        // Implicit super()
        // Write via a method that does nothing else
        assignField();
    }
    
    private void assignField() {
        buffer = new StringBuilder("test");
    }
    
    @Override
    void overriddenMethod() {
        StringBuilder sb = buffer;
        System.out.println("Buffer: " + sb);
    }
}