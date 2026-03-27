// A non-format method call with enclosing String and Object[] but extra parameters should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    // Variant 5: Static factory method creates instance, call via instance method
    private final String fmt;
    private final Object[] args;
    private final boolean flag;
    
    private NegCase4_Var5(String fmt, Object[] args, boolean flag) {
        this.fmt = fmt;
        this.args = args;
        this.flag = flag;
    }
    
    static NegCase4_Var5 create(String fmt, Object[] args, boolean flag) {
        return new NegCase4_Var5(fmt, args, flag);
    }
    
    void execute() {
        System.out.println(flag ? fmt : "No format");
    }
    
    public static void main(String[] args) {
        NegCase4_Var5 obj = create("Hello %s", new Object[]{"world"}, true);
        obj.execute();
    }
}