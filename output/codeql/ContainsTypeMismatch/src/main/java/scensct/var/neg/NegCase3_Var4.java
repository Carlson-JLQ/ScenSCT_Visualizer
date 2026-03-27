// Calling a method named contains on a non-collection type should not be flagged.
package scensct.var.neg;

public class NegCase3_Var4 {
    static class CustomContainer {
        public boolean contains(Object obj) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        CustomContainer container = new CustomContainer();
        Object arg = "test";
        for (int i = 0; i < 1; i++) {
            boolean result = container.contains(arg);
            System.out.println(result);
            break;
        }
    }
}