// Calling a method named contains on a non-collection type should not be flagged.
package scensct.var.neg;

public class NegCase3_Var5 {
    static class CustomContainer {
        private Object data;
        
        public boolean contains(Object obj) {
            return false;
        }
    }
    
    static CustomContainer makeContainer() {
        return new CustomContainer();
    }
    
    public static void main(String[] args) {
        boolean result = makeContainer().contains("test");
        System.out.println(result);
    }
}